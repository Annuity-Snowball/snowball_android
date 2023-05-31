package com.example.snowball.utils

import android.util.Log
import com.example.snowball.model.common.ErrorResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.Response


fun <T> handle400Error(
    response: Response<T>
){
    val gson = Gson()
    val type = object : TypeToken<ErrorResponse>() {}.type
    val errorResponse: ErrorResponse? = gson.fromJson(response.errorBody()?.charStream(), type)

    Log.e("AuthScreen.SignInScreen", "signIn failed with code 400: $errorResponse")
}