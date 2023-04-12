package com.example.snowball.ui.component.add.result

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.snowball.ui.screen.add.portfolio_input.PortfolioInputScreenViewModel
import com.example.snowball.ui.theme.MainBlack
import com.example.snowball.ui.theme.MainGreen
import com.example.snowball.ui.theme.MainGreenTransparent
import com.example.snowball.ui.theme.MainGrey

@Composable
fun ResultTable(){

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            modifier = Modifier
                .padding(vertical = 8.dp),
            text = "투입한 금액 : ${PortfolioInputScreenViewModel.BackTestResult.result.value.result_without_tax["투입한 금액"]}원",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TableHeader()
        TableBody()
    }
}

@Composable
fun TableHeader(
    firstItemWeight: Float = .2f,
    secondItemWeight: Float = .4f,
    thirdItemWeight: Float = .4f
){
    Row(
        modifier = Modifier
            .background(MainGreenTransparent)
    ) {
        TableCell(text = "비교군", weight = firstItemWeight, borderColor = MainGreenTransparent )
        TableCell(text = "세제혜택x", weight = secondItemWeight, borderColor = MainGreenTransparent )
        TableCell(text = "세제혜택o", weight = thirdItemWeight, borderColor = MainGreenTransparent )
    }
}

@Composable
fun TableBody(
    firstItemWeight: Float = .2f,
    secondItemWeight: Float = .4f,
    thirdItemWeight: Float = .4f
) {
    PortfolioInputScreenViewModel.BackTestResult.result.value.apply {
        Row {
            TableCell(text = "승률", weight = firstItemWeight, fontSize = 13 )
            TableCell(text = "${result_without_tax["승률"]}%", weight = secondItemWeight )
            TableCell(text = "${result_with_tax["승률"]}%", weight = thirdItemWeight )
        }
        Row {
            TableCell(text = "총 수익률", weight = firstItemWeight, fontSize = 13 )
            TableCell(text = "${result_without_tax["총 수익률"]}%", weight = secondItemWeight )
            TableCell(text = "${result_with_tax["총 수익률"]}%", weight = thirdItemWeight )
        }
        Row {
            TableCell(text = "가치", weight = firstItemWeight, fontSize = 13 )
            TableCell(text = "${result_without_tax["포트폴리오 가치"].asInt}원", weight = secondItemWeight, fontSize = 13  )
            TableCell(text = "${result_with_tax["포트폴리오 가치"].asInt}원", weight = thirdItemWeight, fontSize = 13  )
        }
        Row {
            TableCell(text = "월 평균", weight = firstItemWeight, fontSize = 13 )
            TableCell(text = "${result_without_tax.getAsJsonObject("월 수익률 추이")["월 수익률 평균"]}%", weight = secondItemWeight )
            TableCell(text = "${result_with_tax.getAsJsonObject("월 수익률 추이")["월 수익률 평균"]}%", weight = thirdItemWeight )
        }
    }

}

@Composable
fun RowScope.TableCell(
    text: String,
    weight: Float,
    fontSize: Int = 14,
    borderColor: Color = MainGrey
) {
    Text(
        text = text,
        modifier = Modifier
            .border(1.dp, borderColor)
            .weight(weight)
            .padding(8.dp),
        color = MainBlack,
        fontSize = fontSize.sp,
        fontWeight = FontWeight.Bold
    )
}