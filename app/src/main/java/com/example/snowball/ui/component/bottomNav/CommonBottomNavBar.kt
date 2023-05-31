package com.example.snowball.ui.component.bottomNav

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.ContentPasteSearch
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.PlaylistAdd
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.snowball.ui.component.modifierExtension.drawColoredShadow
import com.example.snowball.ui.component.navigation.AddDestination
import com.example.snowball.ui.component.navigation.HomeDestination
import com.example.snowball.ui.component.navigation.MyPageDestination
import com.example.snowball.ui.component.navigation.SearchDestination
import com.example.snowball.ui.theme.MainGreen

@Composable
fun CommonBottomNavBar(
    navController: NavController
) {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf(
        HomeDestination.HOME_ROUTER,
        SearchDestination.SEARCH_ROUTER,
        AddDestination.ADD_ROUTER,
        MyPageDestination.MYPAGE_ROUTER
    )
    val navIcons = listOf(
        Icons.Rounded.Home,
        Icons.Rounded.ContentPasteSearch,
        Icons.Rounded.PlaylistAdd,
        Icons.Rounded.AccountCircle
    )

    NavigationBar(
        modifier = Modifier
            .drawColoredShadow(offsetX = 2.dp)
            .height(70.dp),
        containerColor = Color.White,
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(navIcons[index], contentDescription = item)
                },
                label = {
                    Column {
                        Text(item)
                    }
                },
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    navController.navigate(item)
                    // TODO("페이지 전환 후 돌아 올 때 상태를 저장하게 바꿔야함.")
/*                    {
//                        navController.graph.startDestinationRoute?.let { route ->
//                            popUpTo(route) {
//                                saveState = true
//                            }
//                        }
//                        launchSingleTop = true
//                        restoreState = true
//                    } */
                },
                alwaysShowLabel = true,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    indicatorColor = MainGreen
                ),
            )
        }
    }
}