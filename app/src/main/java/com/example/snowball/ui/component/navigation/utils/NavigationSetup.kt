package com.example.snowball.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.snowball.ui.component.navigation.*


@Composable
fun NavigationSetup(navController: NavHostController) {

    val loginAction = remember(navController){LoginAction(navController)}
    val homeAction = remember(navController){HomeAction(navController)}
    val searchAction = remember(navController){SearchAction(navController)}
    val addAction = remember(navController){AddAction(navController)}
    val myPageAction = remember(navController){MyPageAction(navController)}

    NavHost(navController, startDestination = AddDestination.ADD_ROUTER) {
        loginNavGraph(loginAction = loginAction)
        homeNavGraph(homeAction = homeAction)
        searchNavGraph(searchAction = searchAction)
        addNavGraph(addAction = addAction)
        myPageNavGraph(myPageAction = myPageAction)
    }
}