package com.example.snowball.api.membership

import com.example.snowball.model.auth.LoginRequest
import com.example.snowball.model.auth.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface AuthApi {
    @POST("/auth/login")
    suspend fun login(
        @Body loginRequest: LoginRequest
    ): Response<LoginResponse>

    @GET("/auth/verify")
    suspend fun verify(
        @Header("Authorization") accessToken: String,
        @Header("x-refresh-token") refreshToken: String
    ): Response<String>
}