package com.example.snowball.api

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {

    private const val BASE_URL: String = "http://113.198.137.200:20001"
    private val retrofit: Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
    }

    val addApiService: AddApi by lazy {
        retrofit.build()
            .create(AddApi::class.java)
    }
    /*
    val authApiService: AuthApi by lazy {
        retrofit.build()
            .create(AuthApi::class.java)
    }
    val chatApiService: ChatApi by lazy {
        retrofit.build()
            .create(ChatApi::class.java)
    }
    */
}