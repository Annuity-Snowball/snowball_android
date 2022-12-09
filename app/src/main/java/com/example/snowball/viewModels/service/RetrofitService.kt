package com.example.snowball.viewModels.service

import com.example.snowball.model.DTO.PortfolioDto
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.Body
import retrofit2.http.POST

class RetrofitService {
    companion object {
        private const val baseUrl = "http://43.200.175.52:8001"

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val backTest: BackTestService = retrofit.create(BackTestService::class.java)
    }
}