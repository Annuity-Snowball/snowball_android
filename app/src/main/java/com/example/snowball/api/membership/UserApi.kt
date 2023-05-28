package com.example.snowball.api.membership

import com.example.snowball.model.auth.SignUpRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface UserApi {
    @GET("/user/checkDuplicate/email/{email}")
    suspend fun checkEmailDuplication(
        @Path("email") email:String
    ): Response<String>

    @GET("/user/checkDuplicate/username/{username}")
    suspend fun checkUsernameDuplication(
        @Path("username") username:String
    ): Response<String>

    @POST("/user/signup")
    suspend fun signUp(
        @Body signUpRequest: SignUpRequest
    ): Response<String>
}