package com.example.snowball.ui.screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SnowballAppViewModel: ViewModel() {

    companion object BottomBarState {
        private val PrivateBottomBarToggle = mutableStateOf(true)

        val toggleBottomBar: () -> Unit = {
            PrivateBottomBarToggle.value = !(PrivateBottomBarToggle.value)
        }
    }

    val bottomBarToggle = PrivateBottomBarToggle
}