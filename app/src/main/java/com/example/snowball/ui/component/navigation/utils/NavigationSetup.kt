package com.example.snowball.ui.component.navigation.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.snowball.ui.component.navigation.*


@Composable
fun NavigationSetup(navController: NavHostController) {

    val startDestination = HomeDestination.HOME_ROUTER

    val authAction = remember(navController){AuthAction(navController)}
    val homeAction = remember(navController){HomeAction(navController)}
    val searchAction = remember(navController){SearchAction(navController)}
    val addAction = remember(navController){AddAction(navController)}
    val myPageAction = remember(navController){MyPageAction(navController)}

    NavHost(navController, startDestination = startDestination) {
        loginNavGraph(authAction = authAction)
        homeNavGraph(homeAction = homeAction)
        searchNavGraph(searchAction = searchAction)
        addNavGraph(addAction = addAction)
        myPageNavGraph(myPageAction = myPageAction)
    }
}