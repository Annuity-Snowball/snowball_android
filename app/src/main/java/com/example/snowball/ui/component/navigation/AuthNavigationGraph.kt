package com.example.snowball.ui.component.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.snowball.ui.screen.auth.main.AuthScreen

fun NavGraphBuilder.loginNavGraph(
    authAction: AuthAction
){
    navigation(startDestination = AuthDestination.AUTH_SCREEN, route = AuthDestination.AUTH_ROUTER){
        composable(AuthDestination.AUTH_SCREEN){
            AuthScreen()
        }
    }
}

class AuthAction(navController: NavController){

}