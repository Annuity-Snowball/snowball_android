package com.example.snowball.view.screen

import android.widget.EditText
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun addScreen() {
    var text by remember { mutableStateOf("") }
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(top = 80.dp)
        ) {

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
                value = text,
                onValueChange = {
                    text = it
                },
                label = { Text(text = "포트폴리오 이름") },
                singleLine = true,
                placeholder = { Text(text = "포트폴리오 이름을 입력하세요.") },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color(red = 243, green = 243, blue = 250)
                )
            )

            Row(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            ) {
                Spacer(modifier = Modifier.width(280.dp))

                Text(
                    modifier = Modifier
                        .padding(top = 16.dp),
                    text = "전략 총 0 개",
                    fontSize = 18.sp
                )
            }

            Divider(
                modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp),
                thickness = 2.dp,
                color = Color(0x66, 0xC6, 0xA3)
            )

        }
    }
}