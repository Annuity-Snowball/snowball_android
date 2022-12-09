package com.example.snowball.model.DTO

import com.google.gson.annotations.SerializedName

data class PortfolioDto(
    @SerializedName("id")
    var id: Int = 1,

    @SerializedName("name")
    var name: String = "",

    @SerializedName("startDate")
    var startDate: String = "",

    @SerializedName("endDate")
    var endDate: String= "",

    @SerializedName("rebalancingDuration")
    var rebalancingDuration: Int = 0,

    @SerializedName("inputMoney")
    var inputMoney: Int = 0,

    @SerializedName("startMoney")
    var startMoney: Int = 0,

    @SerializedName("inputWay")
    var inputWay: Int = 0,

    @SerializedName("strategyNumber")
    var strategyNumber: Int = 0,

    @SerializedName("strategies")
    var strategies: MutableList<StrategyDto> = mutableListOf()
)
//{
//    "id":1,
//    "name":"트와이스 결혼 적금",
//    "startDate":"2017-01-01",
//    "endDate":"2018-01-09",
//    "rebalancingDuration":6,
//    "inputMoney":30000,
//    "startMoney":300000,
//    "inputWay":0,
//    "strategyNumber":3,
//    "strategies": [
//    {
//        "id":1,
//        "productName":"PER 저",
//        "productNumber":3,
//        "productRate":30,
//        "productStartRate":0,
//        "productEndRate":0
//    },
//    {
//        "id":2,
//        "productName":"PBR 고",
//        "productNumber":3,
//        "productRate":40,
//        "productStartRate":0,
//        "productEndRate":0
//    },
//    {
//        "id":3,
//        "productName":"PER 고",
//        "productNumber":3,
//        "productRate":30,
//        "productStartRate":0,
//        "productEndRate":0
//    }
//    ]
//}