package com.example.snowball.ui.screen.add.portfolio_input

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.snowball.ui.component.add.portfolio_input.GetResultButton
import com.example.snowball.ui.component.add.portfolio_input.PortfolioInputTextField
import com.example.snowball.ui.component.add.portfolio_input.PortfolioInputTopBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PortfolioInputScreen(
    portfolioInputScreenViewModel: PortfolioInputScreenViewModel = PortfolioInputScreenViewModel(),
    navigateToResultScreen: () -> Unit,
    onBack: () -> Unit
){
    Scaffold(
        topBar = { PortfolioInputTopBar(onBack = onBack)},
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 80.dp, bottom = 16.dp)
                    .background(Color.White)
            ) {
                PortfolioInputContent(
                    portfolioInputScreenViewModel = portfolioInputScreenViewModel,
                    navigateToResultScreen = navigateToResultScreen
                )
            }
        }
    )
}

@Composable
fun PortfolioInputContent(
    portfolioInputScreenViewModel: PortfolioInputScreenViewModel,
    navigateToResultScreen: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column() {
            PortfolioInputTextField(
                value = portfolioInputScreenViewModel.startDate.value,
                setValue = portfolioInputScreenViewModel.setStartDate,
                label = "시작 일자",
                keyboardType = KeyboardType.Text
            )

            PortfolioInputTextField(
                value = portfolioInputScreenViewModel.endDate.value,
                setValue = portfolioInputScreenViewModel.setEndDate,
                label = "마지막 일자",
                keyboardType = KeyboardType.Text
            )

            PortfolioInputTextField(
                value = portfolioInputScreenViewModel.rebalancingDuration.value,
                setValue = portfolioInputScreenViewModel.setRebalancingDuration,
                label = "리밸런싱 주기",
                keyboardType = KeyboardType.Decimal
            )

            PortfolioInputTextField(
                value = portfolioInputScreenViewModel.inputMoney.value,
                setValue = portfolioInputScreenViewModel.setInputMoney,
                label = "입금 금액",
                keyboardType = KeyboardType.Decimal
            )

            PortfolioInputTextField(
                value = portfolioInputScreenViewModel.startMoney.value,
                setValue = portfolioInputScreenViewModel.setStartMoney,
                label = "초기 금액",
                keyboardType = KeyboardType.Decimal
            )
        }
        GetResultButton(
            portfolioInputScreenViewModel = portfolioInputScreenViewModel,
            navigateToResultScreen = navigateToResultScreen
        )
    }
}