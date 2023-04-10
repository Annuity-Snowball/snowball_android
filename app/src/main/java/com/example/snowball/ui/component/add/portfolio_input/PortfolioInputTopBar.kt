package com.example.snowball.ui.component.add.portfolio_input

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.snowball.ui.component.modifierExtension.drawColoredShadow
import com.example.snowball.ui.screen.SnowballAppViewModel
import com.example.snowball.ui.theme.MainBlack

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PortfolioInputTopBar(
    onBack: () -> Unit
) {
    TopAppBar(
        modifier = Modifier
            .drawColoredShadow(offsetX = 2.dp),
        title = { Text(text = "포트폴리오 정보 입력")},
        navigationIcon = {
            BackIconBtnWithBottomToggle (
                onBack = onBack
            )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color.White
        )
    )
}

@Composable
fun BackIconBtnWithBottomToggle(
    onBack: () -> Unit,
){
    IconButton(onClick = {
        SnowballAppViewModel.BottomBarState.toggleBottomBar()
        onBack()
    }) {
        Icon(
            imageVector = Icons.Rounded.ArrowBack,
            contentDescription = "Go Back",
            tint = MainBlack
        )
    }
}