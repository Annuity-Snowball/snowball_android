package com.example.snowball.ui.screen.add.strategy_input

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.snowball.model.add.StrategyModel
import com.example.snowball.ui.screen.SnowballAppViewModel
import com.example.snowball.ui.screen.add.main.AddScreenViewModel
import com.example.snowball.ui.screen.add.select.SelectScreenViewModel
import com.example.snowball.ui.theme.MainGreen
import com.example.snowball.ui.theme.MainGrey
import com.example.snowball.ui.theme.SecondGrey

@Composable
fun InputButton(
    strategyInputScreenViewModel: StrategyInputScreenViewModel,
    navigateToAddScreen: () -> Unit,
    selectedItem: String
) {
    Button(
        onClick = {
            AddScreenViewModel.Strategies.addStrategyList(
                StrategyModel(
                    productName = selectedItem,
                    productNumber = strategyInputScreenViewModel.strategyNumber.value.toInt(),
                    productRate = strategyInputScreenViewModel.strategyRatio.value.toInt()
                )
            )
            SelectScreenViewModel.Depth.resetDepth()
            SnowballAppViewModel.BottomBarState.toggleBottomBar()
            navigateToAddScreen()
        },
        enabled = enableInputButton(strategyInputScreenViewModel),
        shape = ShapeDefaults.ExtraSmall,
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MainGreen,
            contentColor = Color.White,
            disabledContainerColor = MainGrey,
            disabledContentColor = SecondGrey
        )
    ) {
        Text(
            text = "등록",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

fun enableInputButton(
    strategyInputScreenViewModel: StrategyInputScreenViewModel
): Boolean {
    strategyInputScreenViewModel.let {
        return it.strategyNumber.value != "" && it.strategyRatio.value != ""
    }
}