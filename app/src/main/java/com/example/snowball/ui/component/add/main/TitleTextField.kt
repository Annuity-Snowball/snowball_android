package com.example.snowball.ui.component.add.main

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.snowball.ui.theme.TextFieldBorderColor
import com.example.snowball.ui.theme.TextFieldContentColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TitleTextField(
    value: String,
    setValue: (String) -> Unit
){
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth(),
        value = value,
        onValueChange = {
            setValue(it)
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = TextFieldBorderColor,
            focusedBorderColor = TextFieldBorderColor,
            containerColor = TextFieldContentColor
        ),
        placeholder = {
            TitleTextFieldPlaceHolder(
                value = "포트폴리오 제목을 입력하세요",
                color = TextFieldBorderColor
            )
        },
        shape = ShapeDefaults.ExtraSmall
    )
}

@Composable
fun TitleTextFieldPlaceHolder(
    value: String,
    color: androidx.compose.ui.graphics.Color
) {
    Text(
        text = value,
        color = color
    )
}