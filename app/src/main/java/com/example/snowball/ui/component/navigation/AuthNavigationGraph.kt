package com.example.snowball.ui.component.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.snowball.ui.screen.auth.main.AuthScreen
import com.example.snowball.ui.screen.auth.signIn.SignInScreen
import com.example.snowball.ui.screen.auth.signUp.SignUpScreen

fun NavGraphBuilder.loginNavGraph(
    authAction: AuthAction
){
    navigation(startDestination = AuthDestination.AUTH_SCREEN, route = AuthDestination.AUTH_ROUTER){
        composable(AuthDestination.AUTH_SCREEN) {
            AuthScreen(
                navigateToSignInScreen = authAction.navigateToSignInScreen,
                navigateToSignUpScreen = authAction.navigateToSignUpScreen
            )
        }
        composable(AuthDestination.SIGNIN_SCREEN) {
            SignInScreen(
                onBack = authAction.upPress,
                navigateToHome = authAction.navigateToHome
            )
        }
        composable(AuthDestination.SIGNUP_SCREEN) {
            SignUpScreen(
                onBack = authAction.upPress,
                navigateToSignInScreen = authAction.navigateToSignInScreen
            )
        }
    }
}

class AuthAction(navController: NavController){
    val upPress: () -> Unit = {
        navController.navigateUp()
    }

    val navigateToSignInScreen: () -> Unit = {
        navController.navigate(AuthDestination.SIGNIN_SCREEN)
    }

    val navigateToSignUpScreen: () -> Unit = {
        navController.navigate(AuthDestination.SIGNUP_SCREEN)
    }

    val navigateToHome: () -> Unit = {
        navController.navigate(HomeDestination.HOME_SCREEN)
    }
}