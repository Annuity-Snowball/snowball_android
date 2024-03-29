package com.example.snowball.ui.screen.add.result


import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.snowball.ui.component.add.result.*
import com.example.snowball.ui.screen.add.portfolio_input.PortfolioInputScreenViewModel
import com.github.mikephil.charting.data.Entry
import com.google.gson.JsonObject

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultScreen(
    resultScreenViewModel: ResultScreenViewModel = ResultScreenViewModel(),
    navigateToAddScreen: () -> Unit,
    onBack: () -> Unit
) {
    Scaffold(
        topBar = { ResultTopBar(onBack = onBack)},
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(top = 80.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
            ) {
                ResultScreenContent(resultScreenViewModel = resultScreenViewModel)
            }
        }
    )
}

@Composable
fun ResultScreenContent(
    resultScreenViewModel: ResultScreenViewModel
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (PortfolioInputScreenViewModel.BackTestResult.result.value.onlyMoney != JsonObject()) {
            ResultLineChart()
            ResultTable()
            DailyBenefitChart()
            ReceiveWayTable()
            ButtonRow()
        } else {
            BufferingMotion()
        }
    }
}