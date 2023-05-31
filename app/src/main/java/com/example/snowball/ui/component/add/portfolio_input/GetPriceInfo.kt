package com.example.snowball.ui.component.add.portfolio_input

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.KeyboardType
import com.example.snowball.ui.screen.add.portfolio_input.PortfolioInputScreenViewModel

@Composable
fun GetPriceInfo(
    portfolioInputScreenViewModel: PortfolioInputScreenViewModel
) {
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