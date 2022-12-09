package com.example.snowball.view.screen.add

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.ChevronRight
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectScreen(
    onNextButtonClicked: () -> Unit,
    options: List<String>,
    modifier: Modifier = Modifier,
    pickedStrategy:MutableState<String> = mutableStateOf(""),
    selection:MutableState<String> = mutableStateOf("")
) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .background(Color.White),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            var selectedItem by remember{
                mutableStateOf(options[0])
            }
            val scrollState = rememberScrollState()
            Column(
                modifier = Modifier
                    .verticalScroll(
                        scrollState
                    )
            ) {
                options.forEach {
                    val containerColor = if(it == selectedItem) {
                        Color(0xFF, 0x77, 0x59)
                    } else {
                        Color(255, 255, 255)
                    }

                    val contentColor = if(it == selectedItem) {
                        Color.White
                    } else {
                        Color.Black
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .selectable(
                                selected = (selectedItem == it),
                                onClick = {
                                    Log.e("selected item (selectedItem)", selectedItem)
                                    selectedItem = it
                                    Log.e("selected item (selectedItem)", selectedItem)
                                },
                                role = Role.Button
                            )
                            .background(
                                color = containerColor
                            )
                            .height(60.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ){
                        Text(
                            text = it,
                            fontSize = 24.sp,
                            modifier = Modifier
                                .padding(start = 16.dp, end = 16.dp)
                                .align(
                                    alignment = Alignment.CenterVertically
                                ),
                            color = contentColor

                        )

                        Icon(
                            Icons.Rounded.ChevronRight,
                            contentDescription = "for next",
                            tint = contentColor,
                            modifier = Modifier
                                .padding(start = 16.dp, end = 16.dp)
                                .size(48.dp)
                                .align(
                                    alignment = Alignment.CenterVertically
                                )
                        )
                    }
                }
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(alignment = Alignment.End)
                    .padding(start = 16.dp, end = 16.dp, bottom = 86.dp),
                onClick = {
                    pickedStrategy.value = selectedItem
                    Log.e("selected item (selection) ", selection.value)
                    selection.value = selectedItem
                    Log.e("selected item (selection)", selection.value)
                    onNextButtonClicked()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0x66, 0xc6, 0xa3)
                ),
                shape = RoundedCornerShape(5.dp),
                contentPadding = PaddingValues(top = 4.dp, bottom = 4.dp)
            ) {
                Text(
                    modifier = Modifier.padding(4.dp),
                    text = "다음",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

