package com.example.snowball.viewModels

import androidx.lifecycle.ViewModel
import com.example.snowball.model.DTO.StrategyDto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AddViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(StrategyDto())
    val uiState: StateFlow<StrategyDto> = _uiState.asStateFlow()

    fun setStrategyInfo(name: String, number: Int, rate: Int, start: Int=0, end: Int=0){
        _uiState.update { currentState ->
            currentState.copy(
                productName = name,
                productNumber = number,
                productRate = rate,
                productStartRate = start,
                productEndRate = end
            )
        }
    }

    fun setStrategyId(): Int{
        return 1;
    }

    fun resetStrategy(){
        _uiState.value = StrategyDto(id = setStrategyId())
    }
}