package com.example.snowball.ui.component.add.strategy_input

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.snowball.ui.screen.add.strategy_input.StrategyInputScreenViewModel
import com.example.snowball.ui.theme.MainBlack
import com.example.snowball.ui.theme.MainOrange

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputBlockHighOrLow(
    strategyInputScreenViewModel: StrategyInputScreenViewModel
) {
    StrategyInputTextField(
        value = strategyInputScreenViewModel.strategyNumber.value,
        setValue = strategyInputScreenViewModel.setStrategyNumber,
        label = "수량"
    )

    StrategyInputTextField(
        value = strategyInputScreenViewModel.strategyRatio.value,
        setValue = strategyInputScreenViewModel.setStrategyRatio,
        label = "비중"
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputBlockDetail(
    strategyInputScreenViewModel: StrategyInputScreenViewModel
) {

    RangeSlider(
        modifier = Modifier.semantics { contentDescription = "Localized Description" },
        value = strategyInputScreenViewModel.sliderPosition.value,
        onValueChange = {
            strategyInputScreenViewModel.setSliderPosition(it)
            strategyInputScreenViewModel.setStrategyHighValue(it.start.toInt())
            strategyInputScreenViewModel.setStrategyLowValue(it.endInclusive.toInt())
        },
        valueRange = 0f..100f,
        onValueChangeFinished = {  },
        colors = SliderDefaults.colors(
            thumbColor = MainOrange,
            activeTrackColor = MainOrange
        )
    )

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // TODO: 이상 이하 인데 high low 라고 되어 있음 헤깔릴 소지 됨
//        StrategyInputTextField(
//            value = strategyInputScreenViewModel.strategyHighValue.value,
//            setValue = strategyInputScreenViewModel.setStrategyHighValue,
//            label = "이상",
//            width = 170
//        )
//
//        StrategyInputTextField(
//            value = strategyInputScreenViewModel.strategyLowValue.value,
//            setValue = strategyInputScreenViewModel.setStrategyLowValue,
//            label = "이하",
//            width = 170
//        )
    }
    StrategyInputTextField(
        value = strategyInputScreenViewModel.strategyNumber.value,
        setValue = strategyInputScreenViewModel.setStrategyNumber,
        label = "수량"
    )

    StrategyInputTextField(
        value = strategyInputScreenViewModel.strategyRatio.value,
        setValue = strategyInputScreenViewModel.setStrategyRatio,
        label = "비중"
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StrategyInputTextField(
    value: String,
    setValue: (String) -> Unit,
    label: String
) {
    OutlinedTextField(
        value = value,
        onValueChange = {
            setValue(it)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Decimal
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MainOrange,
            focusedLabelColor = MainOrange
        ),
        label = { Text(text = label)}
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StrategyInputTextField(
    value: String,
    setValue: (String) -> Unit,
    label: String,
    width: Int
) {
    OutlinedTextField(
        value = value,
        onValueChange = {
            setValue(it)
        },
        modifier = Modifier
            .width(width.dp)
            .padding(vertical = 16.dp),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Decimal
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MainOrange,
            focusedLabelColor = MainOrange
        ),
        label = { Text(text = label)}
    )
}