package com.example.snowball.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.snowball.Account
import com.example.snowball.Add
import com.example.snowball.Home
import com.example.snowball.Search
import com.example.snowball.view.screen.accountScreen
import com.example.snowball.view.screen.addScreen
import com.example.snowball.view.screen.homeScreen
import com.example.snowball.view.screen.searchScreen

@Composable
fun NavigationSetup(navController: NavHostController) {
    NavHost(navController, startDestination = Home.route) {
        composable(Home.route) {
            homeScreen()
        }
        composable(Search.route) {
            searchScreen()
        }
        composable(Add.route) {
            addScreen()
        }
        composable(Account.route) {
            accountScreen()
        }
    }
}