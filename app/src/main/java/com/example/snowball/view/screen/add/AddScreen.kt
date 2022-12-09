package com.example.snowball.view.screen

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.rounded.HelpOutline
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.snowball.R
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.snowball.model.DTO.PortfolioDto
import com.example.snowball.model.DTO.StrategyDto
import com.example.snowball.model.StrategySelectionSource
import com.example.snowball.view.modifierExtension.drawColoredShadow
import com.example.snowball.view.screen.add.*
import com.example.snowball.viewModels.AddViewModel

enum class AddScreen (@StringRes val title:Int){
    Start(title = R.string.add_screen),

    Select(title = R.string.pick_strategy),
    Indicater(title = R.string.pick_indicater),
    Figure(title = R.string.pick_figure),
    Direct(title = R.string.pick_direct),
    Value(title = R.string.pick_value),

    Info(title = R.string.enter_info),
    PortfolioInfo(title = R.string.portfolioInfo),
    Result(title = R.string.result)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun addTopAppBar(
    currentScreen: AddScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
){
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        modifier = Modifier
            .drawColoredShadow(offsetX = 2.dp),
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "go_back"
                    )
                }
            }
        },
        actions = {
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(
                    imageVector = Icons.Rounded.HelpOutline,
                    contentDescription = "Need help"
                )
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color(255, 255, 255, 255)
        )
    )
}

//@SuppressLint("MutableCollectionMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun addScreen(
    modifier: Modifier = Modifier,
    viewModel: AddViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = AddScreen.valueOf(
        backStackEntry?.destination?.route ?: AddScreen.Start.name
    )

    Scaffold(
        topBar = {
            addTopAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        },
        content = { innerPadding ->
            val uiState by viewModel.uiState.collectAsState()
            val portfolio:PortfolioDto = PortfolioDto()
            val strategyList:MutableList<StrategyDto> = mutableListOf()
//            strategyList.add(
//                StrategyDto(
//                    id = 1,
//                    productName = "PER 고",
//                    productNumber = 2,
//                    productRate = 40
//                )
//            )
//            strategyList.add(
//                StrategyDto(
//                    id = 2,
//                    productName = "PER 저",
//                    productNumber = 3,
//                    productRate = 60
//                )
//            )
            val rememberStrategyList = remember { strategyList }
            val rememberPortfolio = remember { portfolio }
            val pickedStrategy:String
            val rememberStrategy = remember { mutableStateOf("") }
            val firstSelection = remember { mutableStateOf("") }
            val secondSelection by remember { mutableStateOf("") }
            val thirdSelection by remember { mutableStateOf("") }

            NavHost(
                navController = navController,
                startDestination = AddScreen.Start.name,
                modifier = modifier.padding(innerPadding)
            ) {

                composable(route = AddScreen.Start.name) {
                    StartScreen(
                        onNextButtonClicked = {
                            navController.navigate(AddScreen.Select.name)
                        },
                        onInputButtonClicked = {
                            navController.navigate(AddScreen.PortfolioInfo.name)
                        },
                        strategyList = rememberStrategyList,
                        portfolioDto = rememberPortfolio
                    )
                }
                composable(route = AddScreen.Select.name) {
                    SelectScreen(
                        onNextButtonClicked = {
                            if(firstSelection.value == StrategySelectionSource.strategySelection[1]){
                                navController.navigate(AddScreen.Indicater.name)
                            } else{
                                navController.navigate(AddScreen.Direct.name)
                            }
                        },
                        options = StrategySelectionSource.strategySelection,
                        selection = firstSelection
                    )
                }
                composable(route = AddScreen.Direct.name) {
                    SelectScreen(
                        onNextButtonClicked = {
                            navController.navigate(AddScreen.Figure.name)
                        },
                        options = StrategySelectionSource.directChoice
                    )
                }
                composable(route = AddScreen.Indicater.name) {
                    SelectScreen(
                        onNextButtonClicked = {
                            navController.navigate(AddScreen.Figure.name)
                        },
                        options = StrategySelectionSource.indicatorSelection,
                        pickedStrategy = rememberStrategy
                    )
                }
                composable(route = AddScreen.Value.name) {
                    SelectScreen(
                        onNextButtonClicked = {
                            navController.navigate(AddScreen.Figure.name)
                        },
                        options = StrategySelectionSource.indicatorSelection
                    )
                }
                composable(route = AddScreen.Figure.name) {
                    SelectScreen(
                        onNextButtonClicked = {
                            navController.navigate(AddScreen.Info.name)
                        },
                        options = StrategySelectionSource.figureSelection,
                        pickedStrategy = rememberStrategy
                    )
                }
                composable(route = AddScreen.Info.name) {
                    InsertScreen(
                        onNextButtonClicked = {
                            viewModel.setStrategyInfo(
                                it.productName,
                                it.productNumber,
                                it.productRate,
                                it.productStartRate,
                                it.productEndRate
                            )
                            navController.navigate(AddScreen.Start.name)
                        },
                        strategyList = rememberStrategyList,
                        pickedStrategy = rememberStrategy.value
                    )
                }
                composable(route = AddScreen.PortfolioInfo.name){
                    portfolioInputScreen(
                        onInputButtonClicked = {
                            navController.navigate(AddScreen.Result.name)
                        },
                        portfolioDto = rememberPortfolio
                    )
                }
                composable(route = AddScreen.Result.name){
                    resultScreen(
                        onInputButtonClicked = {
                            navController.navigate(AddScreen.Start.name)
                        },
                        portfolioDto = rememberPortfolio
                    )
                }
            }
        }
    )
}

private fun cancelPickAndNavigateToStart(
    viewModel: AddViewModel,
    navController: NavHostController
) {
    viewModel.resetStrategy()
    navController.popBackStack(AddScreen.Start.name, inclusive = false)
}
