package com.example.snowball.ui.component.navigation

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.example.snowball.ui.screen.add.main.AddScreen
import com.example.snowball.ui.screen.add.portfolio_input.PortfolioInputScreen
import com.example.snowball.ui.screen.add.result.ResultScreen
import com.example.snowball.ui.screen.add.select.SelectScreenViewModel
import com.example.snowball.ui.screen.add.strategy_input.StrategyInputScreen
import com.example.snowball.ui.screen.add.select.SelectScreen

fun NavGraphBuilder.addNavGraph(
    addAction: AddAction
){

    val selectScreenViewModel = SelectScreenViewModel()

    navigation(startDestination = AddDestination.ADD_SCREEN, route = AddDestination.ADD_ROUTER){
        composable(AddDestination.ADD_SCREEN){
             AddScreen(
                 navigateToSelectScreen = addAction.navigateToSelectScreen,
                 navigateToPortfolioInputScreen = addAction.navigateToPortfolioInputScreen
             )
        }
        composable(AddDestination.SELECT_SCREEN){
            SelectScreen(
                selectScreenViewModel = selectScreenViewModel,
                navigateToNextScreen = addAction.navigateToSelectScreen,
                navigateToStrategyInputScreen = addAction.navigateToStrategyInputScreen,
                onBack = addAction.upPress
            )
        }
        composable(
            route = "${AddDestination.STRATEGY_INPUT_SCREEN}/{selectedItem}",
            arguments = listOf(navArgument("selectedItem"){type = NavType.StringType})
        ){ backStackEntry ->
            val selectedItem = backStackEntry.arguments?.getString("selectedItem")!!
            StrategyInputScreen(
                selectedItem = selectedItem,
                navigateToAddScreen = addAction.navigateToAddScreen,
                onBack = addAction.upPress
            )
        }
        composable(AddDestination.PORTFOLIO_INPUT_SCREEN) {
            PortfolioInputScreen(
                navigateToResultScreen = addAction.navigateToResultScreen,
                onBack = addAction.upPress
            )
        }
        composable(AddDestination.RESULT_SCREEN) {
            ResultScreen(
                /* TODO: 모든 state 들에 대해서 초기화 해줘야함
                *   addScreen: list, title
                *   selectScreen: depth 등등...
                *   strategy_input : 전략 값
                *   portfolio_input : 들어가는 값, result 들 */
                navigateToAddScreen = addAction.navigateToAddScreen,
                onBack = addAction.upPress
            )
        }
    }

}

class AddAction(navController: NavController){
    val navigateToSelectScreen: () -> Unit = {
        navController.navigate(AddDestination.SELECT_SCREEN)
    }
    val navigateToStrategyInputScreen: (String) -> Unit = { selectedItem ->
        navController.navigate("${AddDestination.STRATEGY_INPUT_SCREEN}/$selectedItem")
    }
    val navigateToAddScreen: () -> Unit = {
        navController.navigate(AddDestination.ADD_SCREEN)
    }
    val navigateToPortfolioInputScreen: () -> Unit = {
        navController.navigate(AddDestination.PORTFOLIO_INPUT_SCREEN)
    }
    val navigateToResultScreen: () -> Unit = {
        navController.navigate(AddDestination.RESULT_SCREEN)
    }
    val upPress: () -> Unit = {
        navController.navigateUp()
    }
}

