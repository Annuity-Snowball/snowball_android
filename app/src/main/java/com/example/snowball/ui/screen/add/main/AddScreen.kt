package com.example.snowball.ui.screen.add.main

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.snowball.ui.component.add.StrategyList
import com.example.snowball.ui.component.add.main.TitleTextField
import com.example.snowball.ui.component.add.main.AssistText
import com.example.snowball.ui.component.add.main.InsertButton
import com.example.snowball.ui.component.add.main.SubmitButton
import com.example.snowball.view.CommonTopAppBar


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AddScreen(
    addScreenViewModel: AddScreenViewModel = AddScreenViewModel(),
    navigateToSelectScreen: () -> Unit,
    navigateToPortfolioInputScreen: () -> Unit
) {
    Scaffold(
        topBar = { CommonTopAppBar() },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 80.dp, horizontal = 16.dp)
                    .background(Color.White)
            ) {
                AddScreenContent(
                    addScreenViewModel = addScreenViewModel,
                    navigateToSelectScreen = navigateToSelectScreen,
                    navigateToPortfolioInputScreen = navigateToPortfolioInputScreen
                )
            }
        }
    )
}

@Composable
fun AddScreenContent(
    addScreenViewModel: AddScreenViewModel,
    navigateToSelectScreen: () -> Unit,
    navigateToPortfolioInputScreen: () -> Unit
){
//    LaunchedEffect(Unit){
//        addScreenViewModel.setDefaultStrategyList()
//    }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column() {
            TitleTextField(
                addScreenViewModel.portfolioTitle.value,
                addScreenViewModel.setPortfolioTitle
            )
            StrategyList(
                strategyList = addScreenViewModel.strategyList,
                navigateToSelectScreen = navigateToSelectScreen
            )
            AssistText()
        }
        Column() {
            InsertButton(
                navigateToSelectScreen = navigateToSelectScreen
            )
            SubmitButton(
                strategyList = addScreenViewModel.strategyList,
                navigateToPortfolioInputScreen = navigateToPortfolioInputScreen
            )
        }
    }


}