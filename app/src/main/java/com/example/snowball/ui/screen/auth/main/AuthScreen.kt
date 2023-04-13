package com.example.snowball.ui.screen.auth.main


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.snowball.ui.component.auth.main.GuideText
import com.example.snowball.ui.component.auth.main.SignInButton
import com.example.snowball.ui.component.auth.main.SignUpButton
import com.example.snowball.ui.screen.SnowballAppViewModel

@Composable
fun AuthScreen(
    authViewModel: AuthViewModel = AuthViewModel(),
    navigateToSignInScreen: () -> Unit,
    navigateToSignUpScreen: () -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 16.dp)
            .background(Color.White),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        AuthScreenContent(
            navigateToSignUpScreen = navigateToSignUpScreen,
            navigateToSignInScreen = navigateToSignInScreen
        )
    }
}

@Composable
fun AuthScreenContent(
    navigateToSignInScreen: () -> Unit,
    navigateToSignUpScreen: () -> Unit
){
    LaunchedEffect(Unit) {
        SnowballAppViewModel.BottomBarState.toggleBottomBarFalse()
    }
    Spacer(modifier = Modifier.padding(top = 20.dp))
    GuideText()
    Column {
        SignUpButton(navigateToSignUpScreen)
        SignInButton(navigateToSignInScreen)
    }
}