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
import com.example.snowball.ui.component.modifierExtension.drawColoredShadow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommonTopAppBar(){
    TopAppBar(
        modifier = Modifier
            .drawColoredShadow(offsetX = 2.dp),
        title = { TopAppBarTitle() },
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
fun TopAppBarTitle(){
    Text(
        "연금 스노우볼",
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}