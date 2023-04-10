package com.example.snowball.ui.component.add.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.snowball.ui.screen.SnowballAppViewModel
import com.example.snowball.ui.theme.MainBlack
import com.example.snowball.ui.theme.MainOrange
import com.example.snowball.ui.theme.SnowballTheme

@Composable
fun InsertButtonWhenEmpty(
    navigateToSelectScreen: () -> Unit
){
    Button(
        onClick = {
            SnowballAppViewModel.toggleBottomBar()
            navigateToSelectScreen()
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = MainBlack
        ),
        modifier = Modifier
            .width(180.dp)
            .shadow(
                elevation = 6.dp,
                shape = ShapeDefaults.ExtraLarge
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "새 전략 추가  ",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Icon(
                imageVector = Icons.Rounded.Add,
                contentDescription = "add strategy button when empty",
                modifier = Modifier.size(30.dp)
            )
        }
    }
}

@Composable
fun InsertButton(
    navigateToSelectScreen: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        Button(
            onClick = {
                SnowballAppViewModel.toggleBottomBar()
                navigateToSelectScreen()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = MainOrange,
                contentColor = Color.White
            ),
            shape = CircleShape,
            contentPadding = PaddingValues(vertical = 4.dp),
            modifier = Modifier
                .shadow(
                    elevation = 6.dp,
                    shape = ShapeDefaults.ExtraLarge
                )
        ) {
            Icon(
                imageVector = Icons.Rounded.Add,
                contentDescription = "add strategy button",
                modifier = Modifier.size(48.dp)
            )
        }
    }
}

@Preview
@Composable
fun InsertButtonWhenEmptyPreview(){
    SnowballTheme {
        Surface {
            InsertButtonWhenEmpty({})
        }
    }
}

@Preview
@Composable
fun InsertButtonPreview(){
    SnowballTheme {
        Surface {
            InsertButton({})
        }
    }
}