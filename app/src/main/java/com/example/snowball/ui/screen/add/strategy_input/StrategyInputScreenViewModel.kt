package com.example.snowball.ui.screen.add.strategy_input

import androidx.annotation.FloatRange
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class StrategyInputScreenViewModel: ViewModel() {

    private val _strategyNumber = mutableStateOf(0)
    val strategyNumber = _strategyNumber
    val setStrategyNumber: (Int) -> Unit = {
        _strategyNumber.value = it
    }

    private val _strategyRatio = mutableStateOf(0)
    val strategyRatio = _strategyRatio
    val setStrategyRatio: (Int) -> Unit = {
        _strategyRatio.value = it
    }

    private val _strategyHighValue = mutableStateOf(0)
    val strategyHighValue = _strategyHighValue
    val setStrategyHighValue: (Int) -> Unit = {
        _strategyHighValue.value = it
        _sliderPosition.value = it.toFloat().._sliderPosition.value.endInclusive
    }

    private val _strategyLowValue = mutableStateOf(100)
    val strategyLowValue = _strategyLowValue
    val setStrategyLowValue: (Int) -> Unit = {
        if(it <= 0){
            _strategyLowValue.value = 1
            _sliderPosition.value = _sliderPosition.value.start..1f
        } else {
            _strategyLowValue.value = it
            _sliderPosition.value = _sliderPosition.value.start..it.toFloat()
        }

    }

    private val _selectedIndex = mutableStateOf(0)
    val selectedIndex = _selectedIndex
    val setSelectedIndex: (Int) -> Unit = {
        _selectedIndex.value = it
    }

    private val _sliderPosition = mutableStateOf(0f..100f)
    val sliderPosition = _sliderPosition
    val setSliderPosition: (ClosedFloatingPointRange<Float>) -> Unit = {
        _sliderPosition.value = it
    }
}