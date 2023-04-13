package com.example.snowball.ui.screen.auth.signIn

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.snowball.ui.component.auth.signin.GuideText
import com.example.snowball.ui.component.auth.signin.SignInButton
import com.example.snowball.ui.component.auth.signin.SignInTextField
import com.example.snowball.ui.component.auth.signup.SignUpTopBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(
    signInViewModel: SignInViewModel = SignInViewModel(),
    navigateToHome: () -> Unit,
    onBack: () -> Unit
){
    Scaffold(
        topBar = { SignUpTopBar(onBack) },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(top = 80.dp, start = 16.dp, end = 16.dp)
            ) {
                SignInContent(
                    signInViewModel = signInViewModel,
                    navigateToHome = navigateToHome
                )
            }
        }
    )
}

@Composable
fun SignInContent(
    signInViewModel: SignInViewModel,
    navigateToHome: () -> Unit
){
    GuideText()
    Spacer(modifier = Modifier.padding(vertical = 20.dp))
    SignInTextField(signInViewModel = signInViewModel)
    Spacer(modifier = Modifier.padding(vertical = 10.dp))
    SignInButton(
        signInViewModel = signInViewModel,
        navigateToHome = navigateToHome
    )
}