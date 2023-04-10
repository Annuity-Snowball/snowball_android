package com.example.snowball.ui.component.add.select

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.snowball.ui.screen.add.select.SelectScreenViewModel
import com.example.snowball.ui.theme.MainGreen
import com.example.snowball.ui.theme.MainGrey
import com.example.snowball.ui.theme.SecondGrey

@Composable
fun NextButton(
    selectScreenViewModel: SelectScreenViewModel,
    navigateToNextScreen: () -> Unit,
    navigateToStrategyInputScreen: (String) -> Unit
) {
    Button(
        onClick = {
            if(
                selectScreenViewModel.strategyItemList.value == SelectScreenViewModel.StrategyItemNames.valuePointer ||
                selectScreenViewModel.strategyItemList.value == SelectScreenViewModel.StrategyItemNames.fundamentalPointer
            ) {
                Log.i("AddScreen.SelectScreen.NextButton", "selectedItem: ${selectScreenViewModel.selectedItem.value}")
                navigateToStrategyInputScreen(selectScreenViewModel.selectedItem.value)
            } else {
                selectScreenViewModel.plusDepth()
                navigateToNextScreen()
                selectScreenViewModel.setTitle()
                selectScreenViewModel.setStrategyItemList()
            }
        },
        enabled = selectScreenViewModel.selectedItem.value != "",
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
            text = "다음",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}