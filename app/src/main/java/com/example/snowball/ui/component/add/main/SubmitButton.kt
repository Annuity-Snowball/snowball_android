package com.example.snowball.ui.component.add.main

import android.util.Log
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
import com.example.snowball.ui.theme.MainGreen
import com.example.snowball.ui.theme.MainGrey
import com.example.snowball.ui.theme.SecondGrey

@Composable
fun SubmitButton(
    strategyList: List<StrategyModel>,
    navigateToPortfolioInputScreen: () -> Unit
){
    Button(
        onClick = {
            SnowballAppViewModel.BottomBarState.toggleBottomBar()
            navigateToPortfolioInputScreen()
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        shape = ShapeDefaults.ExtraSmall,
        colors = ButtonDefaults.buttonColors(
            containerColor = MainGreen,
            contentColor = Color.White,
            disabledContainerColor = MainGrey,
            disabledContentColor = SecondGrey
        ),
        enabled = enableSubmitButton(strategyList)
    ) {
        Text(
            text = "제출",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
        )
    }
}

fun enableSubmitButton(
    strategyList: List<StrategyModel>
): Boolean{
    var ratioSum = 0
    strategyList.forEach {
        ratioSum += it.productRate
    }

    return ((ratioSum == 100) && AddScreenViewModel.Strategies.getPortfolioTitle() != "")
}