package com.example.snowball.viewModels.service

import com.example.snowball.model.DTO.PortfolioDto
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface BackTestService {

    @POST("/backtest/getInfo")
    fun doBackTest(
        @Body info: PortfolioDto
    ) : Call<JsonObject>
}