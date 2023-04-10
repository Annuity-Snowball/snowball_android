package com.example.snowball.model.add

data class StrategyModel(
    val id: Int = 1,
    val productName: String,
    val productNumber: Int,
    val productRate: Int,
    val productStartRate: Int = 0,
    val productEndRate: Int = 0
)

val strategyListModelTestModel: List<StrategyModel> = listOf(
    StrategyModel(
        productName = "PER 고",
        productNumber = 2,
        productRate = 10
    ),
    StrategyModel(
        productName = "PER 저",
        productNumber = 2,
        productRate = 40
    ),
    StrategyModel(
        productName = "PBR 고",
        productNumber = 2,
        productRate = 50
    )
)