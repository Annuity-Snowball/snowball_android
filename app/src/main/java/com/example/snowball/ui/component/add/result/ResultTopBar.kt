package com.example.snowball.ui.component.add.result

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.snowball.model.add.PortfolioResponseModel
import com.example.snowball.ui.component.modifierExtension.drawColoredShadow
import com.example.snowball.ui.screen.add.portfolio_input.PortfolioInputScreenViewModel
import com.example.snowball.ui.theme.MainBlack
import com.google.gson.JsonObject

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultTopBar(
    onBack: () -> Unit
) {
    TopAppBar(
        modifier = Modifier
            .drawColoredShadow(offsetX = 2.dp),
        title = { Text(text = "백테스트 결과") },
        navigationIcon = {
            ResultScreenBackIcon (
                onBack = onBack
            )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color.White
        )
    )
}

@Composable
fun ResultScreenBackIcon(
    onBack: () -> Unit,
){
    IconButton(onClick = {
        PortfolioInputScreenViewModel.BackTestResult.result.value = PortfolioResponseModel()
        onBack()
    }) {
        Icon(
            imageVector = Icons.Rounded.ArrowBack,
            contentDescription = "Go Back",
            tint = MainBlack
        )
    }
}