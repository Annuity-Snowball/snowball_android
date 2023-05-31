package com.example.snowball.ui.component.add.portfolio_input

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.snowball.ui.screen.add.portfolio_input.PortfolioInputScreenViewModel
import com.example.snowball.ui.theme.MainGreen
import com.example.snowball.ui.theme.MainGrey
import com.example.snowball.ui.theme.MainOrange
import com.example.snowball.ui.theme.SecondGrey
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Composable
fun RowScope.defaultButton(
    portfolioInputScreenViewModel: PortfolioInputScreenViewModel,
    onClickEvent: () -> Unit,
    text: String,
    enabled: Boolean
) {
    Button(
        onClick = { onClickEvent() },
        shape = ShapeDefaults.ExtraSmall,
        modifier = Modifier
            .weight(1f),
        colors = ButtonDefaults.buttonColors(
            containerColor = MainOrange,
            contentColor = Color.White,
            disabledContainerColor = MainGrey,
            disabledContentColor = SecondGrey
        ),
        enabled = enabled
    ) {
        Text(
            text = text,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun RowScope.BeforeButton(
    portfolioInputScreenViewModel: PortfolioInputScreenViewModel
) {
    Button(
        onClick = { portfolioInputScreenViewModel.setInsertOptionToDate() },
        shape = ShapeDefaults.ExtraSmall,
        modifier = Modifier
            .weight(1f),
        colors = ButtonDefaults.buttonColors(
            containerColor = MainGreen,
            contentColor = Color.White,
            disabledContainerColor = MainGrey,
            disabledContentColor = SecondGrey
        )
    ) {
        Text(
            text = "이전",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun RowScope.ResultButton(
    portfolioInputScreenViewModel: PortfolioInputScreenViewModel,
    navigateToResultScreen: () -> Unit
) {
    defaultButton(
        portfolioInputScreenViewModel = portfolioInputScreenViewModel,
        onClickEvent = {
            navigateToResultScreen()
            GlobalScope.launch {
                portfolioInputScreenViewModel.testBackTest()
            }
        },
        text = "분석",
        enabled = checkDateEnable(portfolioInputScreenViewModel) &&
                checkPriceEnable(portfolioInputScreenViewModel)
    )
}

@Composable
fun RowScope.NextButton(
    portfolioInputScreenViewModel: PortfolioInputScreenViewModel
) {
    defaultButton(
        portfolioInputScreenViewModel = portfolioInputScreenViewModel,
        onClickEvent = {
           portfolioInputScreenViewModel.setInsertOptionToPrice()
        },
        text = "다음",
        enabled = checkDateEnable(portfolioInputScreenViewModel)
    )
}


private val checkDateEnable: (PortfolioInputScreenViewModel) -> Boolean = {
    it.startDate.value != "" &&
    it.endDate.value != ""
}

private val checkPriceEnable: (PortfolioInputScreenViewModel) -> Boolean = {
    it.rebalancingDuration.value != "" &&
    it.inputMoney.value != "" &&
    it.startMoney.value != ""
}