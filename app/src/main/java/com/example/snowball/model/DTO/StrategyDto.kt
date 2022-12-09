package com.example.snowball.model.DTO

import com.google.gson.annotations.SerializedName

data class StrategyDto(
    @SerializedName("id")
    var id: Int = 0,

    @SerializedName("productName")
    var productName: String = "",

    @SerializedName("productNumber")
    var productNumber: Int = 0,

    @SerializedName("productRate")
    var productRate: Int = 0,

    @SerializedName("productStartRate")
    var productStartRate: Int = 0,

    @SerializedName("productEndRate")
    var productEndRate: Int = 0,
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