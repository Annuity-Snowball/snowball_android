package com.example.snowball

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.snowball.ui.theme.SnowballTheme
import com.example.snowball.view.NavigationSetup
import com.example.snowball.view.bottomNavBar
import com.example.snowball.view.topAppBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            snowballApp()
        }
    }
}

@Composable
fun snowballApp(){
    SnowballTheme {
        Surface{
            scaffoldFunction()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun scaffoldFunction(){

    val navController = rememberNavController()

    Scaffold(
//        topBar = { topAppBar() },
        content = { innerPadding ->
            scaffoldContents(innerPadding = innerPadding, navController)
          },
        bottomBar = { bottomNavBar(navController) },
        containerColor = Color.White,
        contentColor = Color.White
    )
}

@Composable
fun scaffoldContents(
    innerPadding: PaddingValues,
    navController: NavHostController
) {
    NavigationSetup(navController = navController)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SnowballTheme {
        Surface {
            scaffoldFunction()
        }
    }
}