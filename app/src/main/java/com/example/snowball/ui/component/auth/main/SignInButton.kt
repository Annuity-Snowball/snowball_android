package com.example.snowball.ui.component.auth.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.snowball.ui.theme.MainBlack
import com.example.snowball.ui.theme.MainGreen

@Composable
fun SignInButton(
    navigateToSignInScreen: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "이미 계정이 있나요?", color = MainBlack)
        TextButton(onClick = {
            navigateToSignInScreen()
        }) {
            Text(text = "로그인", color = MainGreen)
        }
    }
}