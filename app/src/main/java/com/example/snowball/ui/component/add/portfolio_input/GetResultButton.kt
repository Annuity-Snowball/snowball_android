package com.example.snowball.ui.component.add.portfolio_input

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
import com.example.snowball.ui.theme.MainGrey
import com.example.snowball.ui.theme.MainOrange
import com.example.snowball.ui.theme.SecondGrey
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Composable
fun GetResultButton(
    portfolioInputScreenViewModel: PortfolioInputScreenViewModel,
    navigateToResultScreen: () -> Unit
) {
    Button(
        onClick = {
            navigateToResultScreen()
            GlobalScope.launch {
                portfolioInputScreenViewModel.testBackTest()
            }
        },
        shape = ShapeDefaults.ExtraSmall,
        modifier = Modifier
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = MainOrange,
            contentColor = Color.White,
            disabledContainerColor = MainGrey,
            disabledContentColor = SecondGrey
        ),
        enabled = checkEnable(portfolioInputScreenViewModel)
    ) {
        Text(
            text = "분석",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

private val checkEnable: (PortfolioInputScreenViewModel) -> Boolean = {
    it.startDate.value != "" &&
    it.endDate.value != "" &&
    it.rebalancingDuration.value != "" &&
    it.inputMoney.value != "" &&
    it.startMoney.value != ""
}