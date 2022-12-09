package com.example.snowball.model.DTO

data class TestDTO (
    var allMoneyO:Int,
    var allMoneyX:Int,
    var portValueO: Float,
    var portValueX: Float,
    var returnValueO: Float,
    var returnValueX: Float,
    var winRateO: Float,
    var winRateX: Float,
)
//    포트폴리오 결과 : {'투입한 금액': 4600000, '포트폴리오 가치': 4830981.0, '총 수익률': 5.02,  '승률': 86.23} - 세제혜택 X
//    포트폴리오 결과 : {'투입한 금액': 4600000, '포트폴리오 가치': 5165705.0, '총 수익률': 12.3,  '승률': 90.58} - 세제헤택 0

