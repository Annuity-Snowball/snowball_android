package com.example.snowball.ui.screen.auth.signUp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SignUpViewModel: ViewModel() {
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

    private val _username = mutableStateOf("")
    val username = _username
    val setUsername: (String) -> Unit = {
        _username.value = it
    }
}