package com.example.snowball.ui.screen.auth.main


import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.snowball.ui.screen.SnowballAppViewModel

@Composable
fun AuthScreen(){
    Surface() {
        LaunchedEffect(Unit){
            SnowballAppViewModel.BottomBarState.toggleBottomBar()
        }
        Text(text = "this is auth")
    }
}