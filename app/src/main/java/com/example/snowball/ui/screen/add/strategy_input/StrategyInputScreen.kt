package com.example.snowball.ui.screen.add.strategy_input

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.snowball.ui.component.add.strategy_input.InputBlockDetail
import com.example.snowball.ui.component.add.strategy_input.InputBlockHighOrLow
import com.example.snowball.ui.component.add.strategy_input.SegmentedControl
import com.example.snowball.ui.component.add.strategy_input.StrategyInputTopBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StrategyInputScreen(
    strategyInputScreenViewModel: StrategyInputScreenViewModel = StrategyInputScreenViewModel(),
    selectedItem: String,
    navigateToAddScreen: () -> Unit,
    onBack: () -> Unit
){
    Scaffold(
        topBar = { StrategyInputTopBar(selectedItem = selectedItem, onBack = onBack)},
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 70.dp, start = 16.dp, end = 16.dp)
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                StrategyInputScreenContent(
                    strategyInputScreenViewModel = strategyInputScreenViewModel,
                    selectedItem = selectedItem,
                    navigateToAddScreen = navigateToAddScreen
                )
            }
        }
    )
}

@Composable
fun StrategyInputScreenContent(
    strategyInputScreenViewModel: StrategyInputScreenViewModel,
    selectedItem: String,
    navigateToAddScreen: () -> Unit
) {
    val items = listOf<String>(
        "$selectedItem 고",
        "$selectedItem 저",
        selectedItem
    )
    SegmentedControl(
        items = items,
        defaultSelectedItemIndex = 0
    ) {
        strategyInputScreenViewModel.setSelectedIndex(it)
    }
    if (strategyInputScreenViewModel.selectedIndex.value == 2){
        InputBlockDetail(strategyInputScreenViewModel = strategyInputScreenViewModel)
    } else {
        InputBlockHighOrLow(strategyInputScreenViewModel = strategyInputScreenViewModel)
    }

    InputButton(
        strategyInputScreenViewModel = strategyInputScreenViewModel,
        navigateToAddScreen = navigateToAddScreen,
        selectedItem = items[strategyInputScreenViewModel.selectedIndex.value]
    )
}