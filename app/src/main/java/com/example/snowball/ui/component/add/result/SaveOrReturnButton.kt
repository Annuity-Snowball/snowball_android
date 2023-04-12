package com.example.snowball.ui.component.add.result

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
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
import com.example.snowball.ui.theme.MainGreen
import com.example.snowball.ui.theme.MainGrey
import com.example.snowball.ui.theme.MainOrange
import com.example.snowball.ui.theme.SecondGrey

@Composable
fun ButtonRow(){
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        SaveButton()
        ReturnButton()
    }
}

@Composable
fun SaveButton(

) {
    Button(
        onClick = { /*TODO*/ },
        enabled = true,
        shape = ShapeDefaults.ExtraSmall,
        modifier = Modifier
            .padding(all = 16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MainGreen,
            contentColor = Color.White,
            disabledContainerColor = MainGrey,
            disabledContentColor = SecondGrey
        )
    ) {
        Text(
            text = "저장",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun ReturnButton() {
    Button(
        onClick = { /*TODO*/ },
        enabled = true,
        shape = ShapeDefaults.ExtraSmall,
        modifier = Modifier
            .padding(all = 16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MainOrange,
            contentColor = Color.White,
            disabledContainerColor = MainGrey,
            disabledContentColor = SecondGrey
        )
    ) {
        Text(
            text = "뒤로가기",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}