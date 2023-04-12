package com.example.snowball.ui.component.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.loginNavGraph(
    loginAction: LoginAction
){
    navigation(startDestination = LoginDestination.LOGIN_SCREEN, route = LoginDestination.LOGIN_ROUTER){
        composable(LoginDestination.LOGIN_SCREEN){
            // TODO: 로그인 만들고 추가하기
        }
    }
}

class LoginAction(navController: NavController){

}