package com.example.snowball.ui.screen.add.select

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.snowball.ui.component.add.select.NextButton
import com.example.snowball.ui.component.add.select.SelectItems
import com.example.snowball.ui.component.add.select.SelectTopBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectScreen(
    selectScreenViewModel: SelectScreenViewModel = SelectScreenViewModel(),
    navigateToNextScreen: () -> Unit,
    navigateToStrategyInputScreen: (String) -> Unit,
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            SelectTopBar(
                selectScreenViewModel = selectScreenViewModel,
                onBack = onBack
            )
         },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(top = 70.dp)
            ) {
                SelectScreenContent(
                    selectScreenViewModel = selectScreenViewModel,
                    navigateToNextScreen = navigateToNextScreen,
                    navigateToStrategyInputScreen = navigateToStrategyInputScreen
                )
            }
        }
    )
}

@Composable
fun SelectScreenContent(
    selectScreenViewModel: SelectScreenViewModel,
    navigateToNextScreen: () -> Unit,
    navigateToStrategyInputScreen: (String) -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        SelectItems(
            selectScreenViewModel = selectScreenViewModel
        )
        NextButton(
            selectScreenViewModel = selectScreenViewModel,
            navigateToNextScreen = navigateToNextScreen,
            navigateToStrategyInputScreen = navigateToStrategyInputScreen
        )
    }
}
