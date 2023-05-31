package com.example.snowball.ui.screen.auth.signIn

import android.content.Context
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.snowball.api.membership.MembershipServerClient
import com.example.snowball.model.auth.LoginRequest
import com.example.snowball.ui.screen.SnowballAppViewModel
import com.example.snowball.utils.TokenStore
import com.example.snowball.utils.handle400Error

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

    private val _buttonClicked = mutableStateOf(false)
    val buttonClicked = _buttonClicked
    val toggleButton: () -> Unit = {
        _buttonClicked.value = !(_buttonClicked.value)
    }

    suspend fun signIn(
        context: Context,
        navigateToHome: () -> Unit
    ){
        val requestBody = LoginRequest(
            email = _email.value,
            password = _password.value
        )

        try {
            val response = MembershipServerClient.authApiService.login(requestBody)
            when(response.code()) {
                200 -> {
                    Log.i("AuthScreen.SignInScreen", "signIn success: ${response.body()}")
                    response.body()?.let {
                        saveToken(context, it.accessToken, it.refreshKey)
                    }
                    navigateToHome()
                    SnowballAppViewModel.BottomBarState.toggleBottomBarTrue()
                }
                400 -> {
                    handle400Error(response)
                }
                else -> {
                    Log.e("AuthScreen.SignInScreen", "signIn failed with code: ${response.code()}")
                }
            }
        } catch (e: Exception) {
            Log.e("AuthScreen.SignInScreen", "signIn failed with error: $e")
        }
    }

    private suspend fun saveToken(
        context: Context,
        accessToken: String,
        refreshToken: String
    ) {
        val tokenStore = TokenStore(context)
        tokenStore.saveAccessToken(accessToken)
        tokenStore.saveRefreshToken(refreshToken)
    }
}