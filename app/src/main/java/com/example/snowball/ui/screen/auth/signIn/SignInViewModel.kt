package com.example.snowball.ui.screen.auth.signIn

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SignInViewModel: ViewModel() {
    private val _email = mutableStateOf("")
    val email = _email
    val setEmail: (String) -> Unit = {
        _email.value = it
    }

    private val _password = mutableStateOf("")
    val password = _password
    val setPassword: (String) -> Unit = {
        _password.value = it
    }
}