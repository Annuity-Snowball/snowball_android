package com.example.snowball.ui.component.auth.signup

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.snowball.ui.theme.MainBlack

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpTopBar(
    onBack: () -> Unit
) {
    TopAppBar(
        title = {
            BackIconBtn(
                color = MainBlack,
                onBack = onBack
            )
        },
        colors = TopAppBarDefaults.largeTopAppBarColors(
            containerColor = Color.White
        )
    )
}

@Composable
fun BackIconBtn(
    color: Color,
    onBack: () -> Unit
){
    IconButton(onClick = { onBack() }) {
        Icon(
            imageVector = Icons.Rounded.ArrowBack,
            contentDescription = "Go Back",
            tint = color
        )
    }
}