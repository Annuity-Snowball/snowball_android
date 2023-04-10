package com.example.snowball.ui.component.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.snowball.view.screen.homeScreen

fun NavGraphBuilder.homeNavGraph(
    homeAction: HomeAction
){
    navigation(startDestination = HomeDestination.HOME_SCREEN, route = HomeDestination.HOME_ROUTER){
        composable(HomeDestination.HOME_SCREEN){
            // TODO: homeScreen -> HomeScreen 으로 바꾸기
            homeScreen()
        }
    }
}

class HomeAction(navController: NavController){

}