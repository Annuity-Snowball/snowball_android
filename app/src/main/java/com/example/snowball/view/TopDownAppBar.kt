package com.example.snowball.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.snowball.BottomNavDestination
import com.example.snowball.Home
import com.example.snowball.view.modifierExtension.drawColoredShadow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun topAppBar(){
    TopAppBar(
        modifier = Modifier
            .drawColoredShadow(offsetX = 2.dp),
        title = { topAppBarTitle() },
        navigationIcon = {
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(
                    imageVector = Icons.Rounded.Menu,
                    contentDescription = "menu"
                )
            }
        },
        actions = {
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(
                    imageVector = Icons.Rounded.HelpOutline,
                    contentDescription = "Need help"
                )
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color(255, 255, 255, 255)
        )
    )
}

@Composable
fun bottomNavBar(
    navController: NavController
) {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("HOME", "SEARCH", "ADD", "MY")
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
                        Spacer(modifier = Modifier.height(57.dp))
                        Text(item)
                    }
                },
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    navController.navigate(item) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                      }
                },
                alwaysShowLabel = true,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(255, 255, 255, 255),
                    indicatorColor = Color(0x66, 0xC6, 0xA3, 100)
                ),
            )
        }
    }
}

@Composable
fun topAppBarTitle(){
    Text(
        "연금 스노우볼",
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}