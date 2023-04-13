package com.example.snowball.ui.component.auth.main

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.snowball.ui.theme.MainBlack

@Composable
fun GuideText(){

    @Composable
    fun SingleGuideText(
        text: String,
        fontSize: Int
    ){
        Text(
            text = text,
            color = MainBlack,
            fontWeight = FontWeight.Bold,
            fontSize = fontSize.sp
        )
    }

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SingleGuideText(
            text = "공 굴러가요~",
            fontSize = 24
        )
        SingleGuideText(
            text = "백 테스팅을 통하여 연금을 비교하고",
            fontSize = 20
        )
        SingleGuideText(
            text = "자신만의 최고의 연금을 만드세요~",
            fontSize = 20
        )
    }

}