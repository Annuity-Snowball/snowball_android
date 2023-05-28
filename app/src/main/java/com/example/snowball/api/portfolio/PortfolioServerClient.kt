package com.example.snowball.api.portfolio

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object PortfolioServerClient {

    private const val BASE_URL: String = "http://113.198.137.200:20001"
    private val retrofit: Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
    }

    val portfolioApiService: AddApi by lazy {
        retrofit.build()
            .create(AddApi::class.java)
    }
}