package com.example.snowball.ui.component.auth.main

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.snowball.ui.theme.MainGreen
import com.example.snowball.ui.theme.MainGrey
import com.example.snowball.ui.theme.SecondGrey

@Composable
fun SignUpButton(
    navigateToSignUpScreen: () -> Unit
){
    Button(
        onClick = { navigateToSignUpScreen() },
        enabled = true,
        shape = ShapeDefaults.ExtraSmall,
        modifier = Modifier
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = MainGreen,
            contentColor = Color.White,
            disabledContainerColor = MainGrey,
            disabledContentColor = SecondGrey
        )
    ) {
        Text(
            text = "시작하기",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}