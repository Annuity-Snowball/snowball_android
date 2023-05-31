package com.example.snowball.model.add

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

data class PortfolioRequestModel(
    val id: Int,
    val name: String,
    val startDate: String,
    val endDate: String,
    val rebalancingDuration: Int,
    val inputMoney: Int,
    val startMoney: Int,
    val inputWay: Int = 0,
    val strategyNumber: Int,
    val strategies: List<StrategyModel>
) {
    init {
        productNameEncoder("영업이익률", "OperatingRatio")
        productNameEncoder("순이익률", "ProfitRatio")
        productNameEncoder("부채비율", "DebtRatio")
    }

    private fun productNameEncoder(
        encodeTarget: String,
        changedString: String
    ) {
        strategies.forEach {
            if (it.productName.contains(encodeTarget)) {
                it.productName = it.productName.replace(encodeTarget, changedString)
            }
        }
    }
}

data class PortfolioResponseModel(
    val onlyMoney: JsonObject,
    val value_with_tax: JsonObject,
    val value_without_tax: JsonObject,
    val result_with_tax: JsonObject,
    val result_without_tax: JsonObject,
    @SerializedName("recieve_with_tax")
    val receive_with_tax: JsonArray,
    @SerializedName("recieve_without_tax")
    val receive_without_tax: JsonArray
) {
    constructor() : this(
        onlyMoney = JsonObject(),
        value_with_tax = JsonObject(),
        value_without_tax = JsonObject(),
        result_with_tax = JsonObject(),
        result_without_tax = JsonObject(),
        receive_with_tax = JsonArray(),
        receive_without_tax = JsonArray()
    )
}

/*
{
    "id": 123456,
    "name": "test_0001",
    "startDate": "2017-10-01",
    "endDate": "2018-05-01",
    "rebalancingDuration": 3,
    "inputMoney":700000,
    "startMoney": 30000000,
    "inputWay": 0,
    "strategyNumber": 4,
    "strategies": [
        {
            "id": 123456,
            "productName": "PER 저",
            "productNumber": 2,
            "productRate": 25,
            "productStartRate": 0,
            "productEndRate": 0
        },
        {
            "id": 123456,
            "productName": "PER 고",
            "productNumber": 2,
            "productRate": 25,
            "productStartRate": 0,
            "productEndRate": 0
        },
        {
            "id": 123456,
            "productName": "PER",
            "productNumber": 3,
            "productRate": 25,
            "productStartRate": 10,
            "productEndRate": 15
        },
        {
            "id": 123456,
            "productName": "PBR 저",
            "productNumber": 3,
            "productRate": 25,
            "productStartRate": 0,
            "productEndRate": 0
        }
    ]
}
 */
