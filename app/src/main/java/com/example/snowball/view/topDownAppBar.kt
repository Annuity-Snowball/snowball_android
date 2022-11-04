package com.example.snowball.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.snowball.view.modifierExtension.drawColoredShadow
import kotlinx.coroutines.launch

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
                    imageVector = Icons.Rounded.ArrowBack,
                    contentDescription = "Go back"
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
fun bottomNavBar() {
//    val navController = rememberNavController()
//    NavHost(navController = navController, startDestination = "profile") {
//        composable("HOME") { homeView() }
//        composable("SEARCH") { searchView() }
//        composable("ADD") { addView() }
//        composable("MY") { myView() }
//        /*...*/
//    }

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
                onClick = { selectedItem = index },
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
        "포트폴리오 입력",
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}