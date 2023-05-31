package com.example.snowball.model.add

data class StrategyModel(
    val id: Int = 1,
    var productName: String,
    val productNumber: Int,
    val productRate: Int,
    val productStartRate: Int = 0,
    val productEndRate: Int = 0
)

val strategyListModelTestModel: List<StrategyModel> = listOf(
    StrategyModel(
        productName = "부채비율 고",
        productNumber = 2,
        productRate = 10
    ),
    StrategyModel(
        productName = "영업이익률 저",
        productNumber = 2,
        productRate = 40
    ),
    StrategyModel(
        productName = "순이익률 고",
        productNumber = 2,
        productRate = 50
    )
)