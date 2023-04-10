package com.example.snowball.ui.component.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.snowball.ui.screen.add.main.AddScreen
import com.example.snowball.view.screen.accountScreen

fun NavGraphBuilder.myPageNavGraph(
    myPageAction: MyPageAction
){
    navigation(startDestination = MyPageDestination.MYPAGE_SCREEN, route = MyPageDestination.MYPAGE_ROUTER){
        composable(MyPageDestination.MYPAGE_SCREEN){
            // TODO: accountScreen -> MyPageScreen 으로 바꾸기
            accountScreen()
        }
    }

}

class MyPageAction(navController: NavController){

}