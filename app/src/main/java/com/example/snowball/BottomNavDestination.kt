package com.example.snowball

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.ContentPasteSearch
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.PlaylistAdd
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.snowball.view.screen.accountScreen
import com.example.snowball.view.screen.addScreen
import com.example.snowball.view.screen.homeScreen
import com.example.snowball.view.screen.searchScreen


interface BottomNavDestination {
    val icon: ImageVector
    val route: String
    val screen: @Composable () -> Unit
}

object Home: BottomNavDestination {
    override val icon: ImageVector = Icons.Rounded.Home
    override val route: String = "HOME"
    override val screen: @Composable () -> Unit = { homeScreen() }
}

object Search: BottomNavDestination {
    override val icon: ImageVector = Icons.Rounded.ContentPasteSearch
    override val route: String = "SEARCH"
    override val screen: @Composable () -> Unit = { searchScreen() }
}

object Add: BottomNavDestination {
    override val icon: ImageVector = Icons.Rounded.PlaylistAdd
    override val route: String = "ADD"
    override val screen: @Composable () -> Unit = { addScreen() }
}

object Account: BottomNavDestination {
    override val icon: ImageVector = Icons.Rounded.AccountCircle
    override val route: String = "MY"
    override val screen: @Composable () -> Unit = { accountScreen() }
}

val bottomNavScreens = listOf(Home, Search, Add, Account)