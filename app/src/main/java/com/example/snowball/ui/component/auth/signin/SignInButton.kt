package com.example.snowball.ui.component.auth.signin

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.snowball.ui.screen.SnowballAppViewModel
import com.example.snowball.ui.screen.auth.signIn.SignInViewModel
import com.example.snowball.ui.theme.MainOrange

@Composable
fun SignInButton(
    signInViewModel: SignInViewModel,
    navigateToHome: () -> Unit
){
    LaunchedEffect(signInViewModel.buttonClicked.value) {
        if (signInViewModel.buttonClicked.value) {
            signInViewModel.signIn(navigateToHome)
            signInViewModel.toggleButton()
        }
    }

    Button(
        onClick = {
            signInViewModel.toggleButton()
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = MainOrange
        ),
        shape = MaterialTheme.shapes.extraSmall,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        enabled = (signInViewModel.email.value != "" && signInViewModel.password.value != "")
    ) {
        Text(text = "로그인", fontWeight = FontWeight.Bold, fontSize = 16.sp)
    }
}