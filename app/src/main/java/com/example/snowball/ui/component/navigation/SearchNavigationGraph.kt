package com.example.snowball.ui.component.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.snowball.view.screen.searchScreen

fun NavGraphBuilder.searchNavGraph(
    searchAction: SearchAction
){
    navigation(startDestination = SearchDestination.SEARCH_SCREEN, route = SearchDestination.SEARCH_ROUTER){
        composable(SearchDestination.SEARCH_SCREEN){
            // TODO: searchScreen -> SearchScreen 으로 바꾸기
            searchScreen()
        }
    }
}

class SearchAction(navController: NavController){

}