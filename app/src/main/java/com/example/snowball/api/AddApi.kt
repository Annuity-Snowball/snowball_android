package com.example.snowball.api

import com.example.snowball.model.add.PortfolioRequestModel
import com.example.snowball.model.add.PortfolioResponseModel
import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AddApi {
    @POST("/backtest/getInfo")
    suspend fun doBackTest(
        @Body portfolioModel: PortfolioRequestModel
    ): Response<PortfolioResponseModel>
}