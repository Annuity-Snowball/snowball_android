package com.example.snowball.ui.screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SnowballAppViewModel: ViewModel() {

    companion object BottomBarState {
        val PrivateBottomBarToggle = mutableStateOf(true)

        val toggleBottomBar: () -> Unit = {
            PrivateBottomBarToggle.value = !(PrivateBottomBarToggle.value)
        }

        val toggleBottomBarFalse: () -> Unit = {
            PrivateBottomBarToggle.value = false
        }

        val toggleBottomBarTrue: () -> Unit = {
            PrivateBottomBarToggle.value = true
        }
    }

    val bottomBarToggle = PrivateBottomBarToggle
}