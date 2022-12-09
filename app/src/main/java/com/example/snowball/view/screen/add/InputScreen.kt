package com.example.snowball.view.screen.add

import android.util.Log
import androidx.annotation.ColorRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.outlined.Cancel
import androidx.compose.material.icons.rounded.Cancel
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.snowball.R
import com.example.snowball.model.DTO.StrategyDto
import com.example.snowball.view.screen.component.SegmentedControl

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InsertScreen(
    onNextButtonClicked: (StrategyDto) -> Unit,
    strategyList:MutableList<StrategyDto>,
    pickedStrategy:String
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            val tempStrategy:StrategyDto = StrategyDto()
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(top = 10.dp, start = 16.dp, end = 16.dp)
            ) {
                Text(
                    text = "전략 분류",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    var testIndex = 0;
                    val selectedIndex = remember { mutableStateOf(testIndex) }

                    val test = listOf<String>("$pickedStrategy 고", "$pickedStrategy 저", pickedStrategy)
                    tempStrategy.productName = test[testIndex]
                    SegmentedControl(
                        items = test,
                        defaultSelectedItemIndex = 0
                    ) {
                        testIndex = it
                        tempStrategy.productName = test[testIndex]
                        selectedIndex.value = testIndex
                        Log.e("selected", "selected = ${test[it]}")
                    }
                    if (selectedIndex.value == 2) {
                        actualFigure(tempStrategy)
                    } else {
                        highAndLow(tempStrategy)
                    }
                }
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(alignment = Alignment.End)
                    .padding(start = 16.dp, end = 16.dp, bottom = 86.dp),
                onClick = {
                    onNextButtonClicked(tempStrategy)
                    strategyList.add(tempStrategy)
                          },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0x66, 0xc6, 0xa3)
                ),
                shape = RoundedCornerShape(5.dp),
                contentPadding = PaddingValues(top = 4.dp, bottom = 4.dp)
            ) {
                Text(
                    modifier = Modifier.padding(4.dp),
                    text = "추가",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun actualFigure(tempSt: StrategyDto){
    var text1 by remember { mutableStateOf("") }
    var text2 by remember { mutableStateOf("") }
    var sliderPosition by remember { mutableStateOf(0f..100f) }
    var min by remember { mutableStateOf("") }
    var max by remember { mutableStateOf("") }
    min = sliderPosition.start.toInt().toString()
    max = sliderPosition.endInclusive.toInt().toString()
    RangeSlider(
        modifier = Modifier.semantics { contentDescription = "Localized Description" },
        value = sliderPosition,
        onValueChange = { sliderPosition = it },
        valueRange = 0f..100f,
        onValueChangeFinished = {
            // launch some business logic update with the state you hold
            // viewModel.updateSelectedSliderValue(sliderPosition)
        },
        colors = SliderDefaults.colors(
            thumbColor = colorResource(id = R.color.core_orange),
            activeTrackColor = colorResource(id = R.color.core_orange)
        )
    )

    Spacer(modifier = Modifier.height(20.dp))

    val trailingIconView1 = @Composable {
        IconButton(
            onClick = {
                text1 = ""
            },
        ) {
            Icon(
                Icons.Outlined.Cancel,
                contentDescription = "",
            )
        }
    }

    val trailingIconView2 = @Composable {
        IconButton(
            onClick = {
                text2 = ""
            },
        ) {
            Icon(
                Icons.Outlined.Cancel,
                contentDescription = "",
            )
        }
    }

    val trailingIconView3 = @Composable {
        IconButton(
            onClick = {
                min = ""
            },
        ) {
            Icon(
                Icons.Outlined.Cancel,
                contentDescription = "",
            )
        }
    }

    val trailingIconView4 = @Composable {
        IconButton(
            onClick = {
                max = ""
            },
        ) {
            Icon(
                Icons.Outlined.Cancel,
                contentDescription = "",
            )
        }
    }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        OutlinedTextField(
            value = min,
            modifier = Modifier.width(180.dp),
            onValueChange = {
                if(min.toInt() > 0 && min.toInt() < max.toInt()) {
                    sliderPosition = it.toFloat()..sliderPosition.endInclusive
                }
            },
            trailingIcon = if (min.isNotBlank()) trailingIconView3 else null,
            label = {
                Text(
                    text = "이상",
                    fontSize = 12.sp
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                cursorColor = colorResource(id = R.color.core_orange),
                focusedBorderColor = colorResource(id = R.color.core_orange),
                unfocusedBorderColor = colorResource(id = R.color.core_black),
                focusedLabelColor = colorResource(id = R.color.core_orange),
                unfocusedLabelColor = colorResource(id = R.color.core_black),
                focusedTrailingIconColor = colorResource(id = R.color.core_orange),
                unfocusedTrailingIconColor = colorResource(id = R.color.core_black),
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal
            )
        )
        
        Spacer(modifier = Modifier.width(20.dp))

        OutlinedTextField(
            value = max,
            modifier = Modifier.width(180.dp),
            onValueChange = {
                if(max.toInt() < 0 && min.toInt() < max.toInt()) {
                    sliderPosition = sliderPosition.start..max.toFloat()
                }
            },
            trailingIcon = if (max.isNotBlank()) trailingIconView4 else null,
            label = {
                Text(
                    text = "이하",
                    fontSize = 12.sp
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                cursorColor = colorResource(id = R.color.core_orange),
                focusedBorderColor = colorResource(id = R.color.core_orange),
                unfocusedBorderColor = colorResource(id = R.color.core_black),
                focusedLabelColor = colorResource(id = R.color.core_orange),
                unfocusedLabelColor = colorResource(id = R.color.core_black),
                focusedTrailingIconColor = colorResource(id = R.color.core_orange),
                unfocusedTrailingIconColor = colorResource(id = R.color.core_black),
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal
            )
        )

    }

    Spacer(modifier = Modifier.height(20.dp))

    OutlinedTextField(
        value = text1,
        onValueChange = { text1 = it },
        modifier = Modifier.fillMaxWidth(),
        trailingIcon = if (text1.isNotBlank()) trailingIconView1 else null,
        label = {
            Text(
                text = "수량",
                fontSize = 12.sp
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            cursorColor = colorResource(id = R.color.core_orange),
            focusedBorderColor = colorResource(id = R.color.core_orange),
            unfocusedBorderColor = colorResource(id = R.color.core_black),
            focusedLabelColor = colorResource(id = R.color.core_orange),
            unfocusedLabelColor = colorResource(id = R.color.core_black),
            focusedTrailingIconColor = colorResource(id = R.color.core_orange),
            unfocusedTrailingIconColor = colorResource(id = R.color.core_black),
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Decimal
        )
    )

    Spacer(modifier = Modifier.height(20.dp))

    OutlinedTextField(
        value = text2,
        onValueChange = { text2 = it },
        modifier = Modifier.fillMaxWidth(),
        trailingIcon = if (text2.isNotBlank()) trailingIconView2 else null,
        label = {
            Text(
                text = "비중",
                fontSize = 12.sp
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            cursorColor = colorResource(id = R.color.core_orange),
            focusedBorderColor = colorResource(id = R.color.core_orange),
            unfocusedBorderColor = colorResource(id = R.color.core_black),
            focusedLabelColor = colorResource(id = R.color.core_orange),
            unfocusedLabelColor = colorResource(id = R.color.core_black),
            focusedTrailingIconColor = colorResource(id = R.color.core_orange),
            unfocusedTrailingIconColor = colorResource(id = R.color.core_black),
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Decimal
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun highAndLow(tempSt: StrategyDto){
    var text1 by remember { mutableStateOf("") }
    var text2 by remember { mutableStateOf("") }

    val trailingIconView1 = @Composable {
        IconButton(
            onClick = {
                text1 = ""
            },
        ) {
            Icon(
                Icons.Outlined.Cancel,
                contentDescription = "",
            )
        }
    }

    val trailingIconView2 = @Composable {
        IconButton(
            onClick = {
                text1 = ""
            },
        ) {
            Icon(
                Icons.Outlined.Cancel,
                contentDescription = "",
            )
        }
    }

    Spacer(modifier = Modifier.height(20.dp))

    OutlinedTextField(
        value = text1,
        onValueChange = {
            text1 = it
            text1.toInt().also { tempSt.productNumber = it }
        },
        modifier = Modifier.fillMaxWidth(),
        trailingIcon = if (text1.isNotBlank()) trailingIconView1 else null,
        label = {
            Text(
                text = "수량",
                fontSize = 12.sp
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            cursorColor = colorResource(id = R.color.core_orange),
            focusedBorderColor = colorResource(id = R.color.core_orange),
            unfocusedBorderColor = colorResource(id = R.color.core_black),
            focusedLabelColor = colorResource(id = R.color.core_orange),
            unfocusedLabelColor = colorResource(id = R.color.core_black),
            focusedTrailingIconColor = colorResource(id = R.color.core_orange),
            unfocusedTrailingIconColor = colorResource(id = R.color.core_black),
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Decimal
        )
    )

    Spacer(modifier = Modifier.height(20.dp))

    OutlinedTextField(
        value = text2,
        onValueChange = {
            text2 = it
            tempSt.productRate = text2.toInt()
        },
        modifier = Modifier.fillMaxWidth(),
        trailingIcon = if (text2.isNotBlank()) trailingIconView2 else null,
        label = {
            Text(
                text = "비중",
                fontSize = 12.sp
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            cursorColor = colorResource(id = R.color.core_orange),
            focusedBorderColor = colorResource(id = R.color.core_orange),
            unfocusedBorderColor = colorResource(id = R.color.core_black),
            focusedLabelColor = colorResource(id = R.color.core_orange),
            unfocusedLabelColor = colorResource(id = R.color.core_black),
            focusedTrailingIconColor = colorResource(id = R.color.core_orange),
            unfocusedTrailingIconColor = colorResource(id = R.color.core_black),
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Decimal
        )
    )
}
