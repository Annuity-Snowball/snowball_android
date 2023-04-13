package com.example.snowball.ui.screen.auth.signUp

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
import com.example.snowball.ui.component.auth.signup.GuideText
import com.example.snowball.ui.component.auth.signup.SignUpButton
import com.example.snowball.ui.component.auth.signup.SignUpTextField
import com.example.snowball.ui.component.auth.signup.SignUpTopBar
/*
    TODO: 핸드폰 인증 추가할 것.
    TODO: 이메일 중복 확인(서버에서) 후 이메일 설정란 추가하기.
 */
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(
    signUpViewModel: SignUpViewModel = SignUpViewModel(),
    navigateToSignInScreen: () -> Unit,
    onBack: () -> Unit
){
    Scaffold(
        topBar = { SignUpTopBar(onBack)},
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(top = 80.dp, start = 16.dp, end = 16.dp)
            ) {
                SignUpContent(
                    signUpViewModel = signUpViewModel,
                    navigateToSignInScreen = navigateToSignInScreen
                )
            }
        }
    )
}

@Composable
fun SignUpContent(
  signUpViewModel: SignUpViewModel,
  navigateToSignInScreen: () -> Unit,
) {
    GuideText()
    Spacer(modifier = Modifier.padding(vertical = 20.dp))
    SignUpTextField(signUpViewModel = signUpViewModel)
    Spacer(modifier = Modifier.padding(vertical = 10.dp))
    SignUpButton(signUpViewModel = signUpViewModel, navigateToSignInScreen = navigateToSignInScreen)
}