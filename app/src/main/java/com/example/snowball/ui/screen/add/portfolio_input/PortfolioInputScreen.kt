package com.example.snowball.ui.screen.add.portfolio_input

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.snowball.ui.component.add.portfolio_input.*

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
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
                    .background(Color.White)
                    .padding(top = 80.dp, bottom = 16.dp)
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

        if(portfolioInputScreenViewModel.insertOption.value == "DATE") {
            Column {
                GetDateInfo(portfolioInputScreenViewModel)
            }
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                NextButton(portfolioInputScreenViewModel)
            }
        } else {
            Column {
                GetPriceInfo(portfolioInputScreenViewModel)
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                BeforeButton(portfolioInputScreenViewModel)
                Spacer(modifier = Modifier.width(20.dp))
                ResultButton(
                    portfolioInputScreenViewModel = portfolioInputScreenViewModel,
                    navigateToResultScreen = navigateToResultScreen
                )
            }

        }
    }
}

@Preview("before, result button preview")
@Composable
fun buttonPreview(
    portfolioInputScreenViewModel: PortfolioInputScreenViewModel = PortfolioInputScreenViewModel()
){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        BeforeButton(portfolioInputScreenViewModel)
        ResultButton(
            portfolioInputScreenViewModel = portfolioInputScreenViewModel,
            navigateToResultScreen = {}
        )
    }
}