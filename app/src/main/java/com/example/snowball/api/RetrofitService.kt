package com.example.snowball.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {
    companion object {
        private const val baseUrl = "http://43.200.175.52:8001"

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val backTest: AddApi = retrofit.create(AddApi::class.java)
    }
}