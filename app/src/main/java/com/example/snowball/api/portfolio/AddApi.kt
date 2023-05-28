package com.example.snowball.api.portfolio

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

    // TODO: 유저 이름으로 불러오는 것 추가하기
}