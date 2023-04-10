package com.example.snowball.ui.component.add.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.snowball.ui.theme.SecondGrey

@Composable
fun AssistText(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        @Composable
        fun AssistText(
            value: String
        ){
            Text(
                text = value,
                color = SecondGrey,
                fontSize = 14.sp
            )
        }
        AssistText(value = "전략을 100% 다 채우시면 포트폴리오를")
        AssistText(value = "제출 하실 수 있습니다.")
    }
}