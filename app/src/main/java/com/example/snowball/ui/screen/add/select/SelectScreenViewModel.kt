package com.example.snowball.ui.screen.add.select

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SelectScreenViewModel: ViewModel() {

    companion object Depth {
        private val _depth = mutableStateOf(0)
        private val _strategyItemList = mutableStateOf(StrategyItemNames.newStrategy)
        private val _title = mutableStateOf("새 전략 추가")
        private val _selectedItem = mutableStateOf("")
        val resetDepth: () -> Unit = {
            _depth.value = 0
            _strategyItemList.value = StrategyItemNames.newStrategy
            _title.value = "새 전략 추가"
            _selectedItem.value = ""
        }
    }

    object StrategyItemNames {
        val newStrategy = listOf(
            "자산 직접 선택",
            "기준 입력"
        )
        val directlySelect = listOf(
            "자산 직접 선택 1",
            "자산 직접 선택 2",
            "자산 직접 선택 3"
        )
        val insertOptions = listOf(
            "벨류 지표",
            "펀데멘탈 지표"
        )
        val valuePointer = listOf(
            "PER",
            "PBR",
            "PSR"
        )
        val fundamentalPointer = listOf(
            "영업이익률",
            "순이익률",
            "부채비율",
            "ROE",
        )
    }

    val title = _title
    val setTitle: () -> Unit = {
        _title.value = _selectedItem.value
    }
    val setTitleWithParam: (String) -> Unit = {
        _title.value = it
    }

    val strategyItemList = _strategyItemList
    val setStrategyItemList: () -> Unit = {
        Log.i("addScreen.selectScreen", "value check: ${_selectedItem.value}")
        when(_selectedItem.value){
            "자산 직접 선택" -> {
                _strategyItemList.value = StrategyItemNames.directlySelect
                setSelectedItem("")
            }
            "기준 입력" -> {
                _strategyItemList.value = StrategyItemNames.insertOptions
                setSelectedItem("")
            }
            "벨류 지표" -> {
                _strategyItemList.value = StrategyItemNames.valuePointer
                setSelectedItem("")
            }
            "펀데멘탈 지표" -> {
                _strategyItemList.value = StrategyItemNames.fundamentalPointer
                setSelectedItem("")
            }
            else -> {
                Log.e("addScreen.selectScreen", "wrong value has entered: ${selectedItem.value}")
            }
        }
    }
    val setStrategyItemListOnBack: () -> Unit = {
        when(_title.value){
            "PBR",
            "PER" -> {
                _strategyItemList.value = StrategyItemNames.valuePointer
                setTitleWithParam("벨류 지표")
            }
            "fundamental 1",
            "fundamental 2",
            "fundamental 3",
            "fundamental 4", -> {
                _strategyItemList.value = StrategyItemNames.fundamentalPointer
                setTitleWithParam("펀데멘탈 지표")
            }
            "벨류 지표",
            "펀데멘탈 지표" -> {
                _strategyItemList.value = StrategyItemNames.insertOptions
                setTitleWithParam("기준 입력")
            }
            "자산 직접 선택",
            "기준 입력" -> {
                _strategyItemList.value = StrategyItemNames.newStrategy
                setTitleWithParam("새 전략 추가")
            }
        }
    }

    val selectedItem = _selectedItem
    val setSelectedItem: (String) -> Unit = {
        _selectedItem.value = it
    }

    val depth = _depth
    val plusDepth: () -> Unit = {
        _depth.value++
    }
    val minusDepth: () -> Unit = {
        _depth.value--
    }
}

