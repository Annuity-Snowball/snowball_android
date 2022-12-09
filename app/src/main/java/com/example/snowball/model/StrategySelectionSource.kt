package com.example.snowball.model

object StrategySelectionSource {
    val strategySelection = listOf<String>(
        "자산직접선택",
        "기준입력"
    )
    val indicatorSelection = listOf<String>(
        "벨류지표",
        "펜데멘탈지표"
    )
    val figureSelection = listOf<String>(
        "PBR",
        "PER",
        "PSR"
    )
    val funda = listOf<String>(
        "영업이익률",
        "총부채비율",
        "유동부채비율"
    )
    val directChoice = listOf<String>(
        "KODEX 200TR",
        "KODEX 200exTOP",
        "KODEX 200중소형",
        "KODEX 200",
        "KODEX 코스닥 150",
        "KODEX 코스피100",
        "KODEX 코스피TR",
        "KODEX 코스피대형주",
        "KODEX 코스피",
        "KODEX KRX300",
        "KODEX KTOP 30",
        "KODEX 삼성그룹",
        "KODEX 현신기술테마엑티스"
    )
}