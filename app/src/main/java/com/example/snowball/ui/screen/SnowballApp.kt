package com.example.snowball.ui.screen

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.snowball.ui.component.bottomNav.CommonBottomNavBar
import com.example.snowball.ui.theme.SnowballTheme
import com.example.snowball.view.CommonTopAppBar
import com.example.snowball.view.NavigationSetup

@Composable
fun SnowballApp(){
    SnowballTheme {
        Surface{
            MainContent()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContent(){

    val snowballAppViewModel = SnowballAppViewModel()
    val navController = rememberNavController()

    Scaffold(
        content = { SetMainNavigation(navController = navController) },
        bottomBar = {
            if (snowballAppViewModel.bottomBarToggle.value) {
                CommonBottomNavBar(navController)
            }
        },
        containerColor = Color.White,
        contentColor = Color.White
    )
}

@Composable
fun SetMainNavigation(
    navController: NavHostController
) {
    NavigationSetup(navController = navController)
}