package com.example.snowball.ui.screen.add.main

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.snowball.model.add.StrategyModel
import com.example.snowball.model.add.strategyListModelTestModel

class AddScreenViewModel: ViewModel() {

    companion object Strategies {
        private val _strategyList = mutableStateListOf<StrategyModel>()
        private val _portfolioTitle = mutableStateOf("test_android")

        val getStrategyList: () -> SnapshotStateList<StrategyModel> = {
            _strategyList
        }

        val getStrategyListSize: () -> Int = {
            _strategyList.size
        }

        val getPortfolioTitle: () -> String = {
            _portfolioTitle.value
        }

        val addStrategyList: (StrategyModel) -> Unit = {
            _strategyList.add(it)
        }
    }

    val portfolioTitle = _portfolioTitle

    val setPortfolioTitle: (String) -> Unit = {
        _portfolioTitle.value = it
    }

    val strategyList = _strategyList

    val setDefaultStrategyList: () -> Unit = {
        _strategyList.removeAll(strategyListModelTestModel)
        _strategyList.addAll(strategyListModelTestModel)
    }
}