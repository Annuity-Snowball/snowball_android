package com.example.snowball.ui.component.auth.signup

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.snowball.ui.screen.auth.signUp.SignUpViewModel
import com.example.snowball.ui.theme.MainOrange

@Composable
fun SignUpButton(
    signUpViewModel: SignUpViewModel,
    navigateToSignInScreen: () -> Unit,
) {
    Button(
        onClick = { navigateToSignInScreen() },
        colors = ButtonDefaults.buttonColors(
            containerColor = MainOrange
        ),
        shape = MaterialTheme.shapes.extraSmall,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        enabled = (signUpViewModel.email.value != "" && signUpViewModel.password.value != "")
    ) {
        Text(text = "회원가입", fontWeight = FontWeight.Bold, fontSize = 16.sp)
    }
}