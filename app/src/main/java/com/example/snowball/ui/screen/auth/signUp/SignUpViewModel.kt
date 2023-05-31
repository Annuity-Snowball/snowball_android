package com.example.snowball.ui.screen.auth.signUp

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.snowball.api.membership.MembershipServerClient
import com.example.snowball.model.auth.SignUpRequest
import com.example.snowball.model.common.ErrorResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SignUpViewModel: ViewModel() {
    private val _email = mutableStateOf("ssk5442@naver.com")
    val email = _email
    val setEmail: (String) -> Unit = {
       _email.value = it
    }

    private val _password = mutableStateOf("909012")
    val password = _password
    val setPassword: (String) -> Unit = {
        _password.value = it
    }

    private val _username = mutableStateOf("ssk5444")
    val username = _username
    val setUsername: (String) -> Unit = {
        _username.value = it
    }

    private val _buttonClicked = mutableStateOf(false)
    val buttonClicked = _buttonClicked
    val toggleButton: () -> Unit = {
        _buttonClicked.value = !(_buttonClicked.value)
    }

    suspend fun signUp(
        navigateToSignInScreen: () -> Unit
    ){
        val requestBody = SignUpRequest(
            email = _email.value,
            username = _username.value,
            password = _password.value
        )

        try {
            val response = MembershipServerClient.userApiService.signUp(requestBody)
            when(response.code()) {
                200 -> {
                    Log.i("AuthScreen.SignUpScreen", "signup success: ${response.body()}")
                    navigateToSignInScreen()
                }
                400 -> {
                    val gson = Gson()
                    val type = object : TypeToken<ErrorResponse>() {}.type
                    val errorResponse: ErrorResponse? = gson.fromJson(response.errorBody()?.charStream(), type)

                    Log.e("AuthScreen.SignUpScreen", "signup failed with code 400 : $errorResponse")
                }
                else -> {
                    Log.e("AuthScreen.SignUpScreen", "signup failed with code: ${response.code()}")
                }
            }
        } catch (e: Exception) {
            Log.e("AuthScreen.SignUpScreen", "signup failed with error: $e")
        }
    }
}