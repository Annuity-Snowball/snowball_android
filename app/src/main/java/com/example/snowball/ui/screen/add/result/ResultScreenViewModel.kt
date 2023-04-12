package com.example.snowball.ui.screen.add.result

import androidx.compose.runtime.mutableStateOf
import com.github.mikephil.charting.data.Entry

class ResultScreenViewModel {

    companion object ChartDatas {
        val onlyMoney = mutableStateOf<List<Entry>?>(null)
        val value_without_tax = mutableStateOf<List<Entry>?>(null)
        val value_with_tax = mutableStateOf<List<Entry>?>(null)
        val result_without_tax = mutableStateOf<List<Entry>?>(null)
        val result_with_tax = mutableStateOf<List<Entry>?>(null)
        val receive_without_tax = mutableStateOf<List<Entry>?>(null)
    }


    /*
        회원 서버
        캐싱 : 토큰, access
        1분
        lecttuce
     */
}