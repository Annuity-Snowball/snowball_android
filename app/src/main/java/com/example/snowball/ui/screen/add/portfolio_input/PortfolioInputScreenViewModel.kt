package com.example.snowball.ui.screen.add.portfolio_input

import android.util.Log
import androidx.compose.material3.DatePickerState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.snowball.api.portfolio.PortfolioServerClient
import com.example.snowball.model.add.PortfolioRequestModel
import com.example.snowball.model.add.PortfolioResponseModel
import com.example.snowball.ui.screen.add.main.AddScreenViewModel

class PortfolioInputScreenViewModel: ViewModel() {

    companion object BackTestResult {
        val result = mutableStateOf<PortfolioResponseModel>(PortfolioResponseModel())
        val resetResult: () -> Unit = {
            result.value = PortfolioResponseModel()
        }
    }

    private val _insertOption = mutableStateOf("DATE")
    val insertOption = _insertOption
    val setInsertOptionToPrice: () -> Unit = {
        _insertOption.value = "PRICE"
    }
    val setInsertOptionToDate: () -> Unit = {
        _insertOption.value = "DATE"
    }

    private val _startDate = mutableStateOf("")
    val startDate = _startDate
    val setStartDate: (String) -> Unit = {
        _startDate.value = it
    }

    private val _endDate = mutableStateOf("")
    val endDate = _endDate
    val setEndDate: (String) -> Unit = {
        _endDate.value = it
    }

    private val _rebalancingDuration = mutableStateOf("")
    val rebalancingDuration = _rebalancingDuration
    val setRebalancingDuration: (String) -> Unit = {
        _rebalancingDuration.value = it
    }

    private val _inputMoney = mutableStateOf("")
    val inputMoney = _inputMoney
    val setInputMoney: (String) -> Unit = {
        _inputMoney.value = it
    }

    private val _startMoney = mutableStateOf("")
    val startMoney = _startMoney
    val setStartMoney: (String) -> Unit = {
        _startMoney.value = it
    }

    suspend fun testBackTest() {
        val requestBody = PortfolioRequestModel(
            id = 1,
            name = AddScreenViewModel.Strategies.getPortfolioTitle(),
            startDate = _startDate.value,
            endDate = _endDate.value,
            rebalancingDuration = _rebalancingDuration.value.toInt(),
            inputMoney = _inputMoney.value.toInt(),
            startMoney = _startMoney.value.toInt(),
            strategyNumber = AddScreenViewModel.Strategies.getStrategyListSize(),
            strategies = AddScreenViewModel.Strategies.getStrategyList()
        )

        try {
            val response = PortfolioServerClient.portfolioApiService.doBackTest(requestBody)
            when(response.code()) {
                200 -> {
                    Log.i("AddScreen.portfolioInputScreen", "result : ${response.body()}")
                    result.value = response.body()!!
                }
                else -> {
                    Log.e("AddScreen.portfolioInputScreen", "do backtest failed with client or server error : ${response.code()}")
                }
            }
        } catch (e: Exception) {
            Log.e("AddScreen.portfolioInputScreen", "do backtest failed with error : $e")
        }
    }
}