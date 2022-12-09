package com.example.snowball.view.screen.add

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.snowball.model.DTO.PortfolioDto
import com.example.snowball.model.DTO.StrategyDto
import com.example.snowball.view.modifierExtension.drawColoredShadow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StartScreen(
    onNextButtonClicked: () -> Unit,
    onInputButtonClicked: () -> Unit,
    modifier: Modifier = Modifier,
    strategyList: MutableList<StrategyDto>,
    portfolioDto: PortfolioDto
) {
    var text by remember { mutableStateOf("") }
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .padding(top = 20.dp)
            ) {
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp)
                        .border(0.5.dp, Color(0xc9, 0xc6, 0xe1), MaterialTheme.shapes.medium),
                    value = text,
                    onValueChange = {
                        text = it
                    },
                    label = { Text(
                        text = "포트폴리오 제목을 입력하세요",
                        color = Color(0xc9, 0xc6, 0xe1),
                        fontSize = 12.sp
                    ) },
                    singleLine = true,
                    placeholder = { Text(text = "문화룡 nba 직관 적금.") },
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color(red = 243, green = 243, blue = 250),
                        cursorColor = Color(red = 243, green = 243, blue = 250),
                        unfocusedIndicatorColor = Color(red = 243, green = 243, blue = 250),
                        focusedIndicatorColor = Color(red = 243, green = 243, blue = 250),
                        disabledIndicatorColor = Color(red = 243, green = 243, blue = 250)
                    )
                )

                Row(
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                ) {
//                    Button(
//                        modifier = Modifier
//                            .height(14.dp),
//                        colors = ButtonDefaults.buttonColors(
//                            containerColor = Color(0x48, 0x48, 0x48)
//                        ),
//                        onClick = {
//                        strategyList.clear()
//                    }) {
//
//                    }

                    Spacer(modifier = Modifier.width(280.dp))

                    Text(
                        modifier = Modifier
                            .padding(top = 10.dp),
                        text = "전략 총 ${strategyList.size} 개",
                        fontSize = 18.sp
                    )
                }

                Divider(
                    modifier = Modifier.padding(top = 10.dp, start = 16.dp, end = 16.dp),
                    thickness = 2.dp,
                    color = Color(0x66, 0xC6, 0xA3)
                )

                Row(
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                ) {
                    Text(
                        modifier = Modifier
                            .padding(top = 10.dp),
                        text = "전략명",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0x66, 0xC6, 0xA3)
                    )

                    Spacer(modifier = Modifier.width(230.dp))

                    Text(
                        modifier = Modifier
                            .padding(top = 10.dp),
                        text = "개수",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0x66, 0xC6, 0xA3)
                    )

                    Spacer(modifier = Modifier.width(40.dp))

                    Text(
                        modifier = Modifier
                            .padding(top = 10.dp),
                        text = "%",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0x66, 0xC6, 0xA3)
                    )
                }

                Divider(
                    modifier = Modifier.padding(top = 10.dp, start = 16.dp, end = 16.dp),
                    thickness = 1.dp,
                    color = Color(0x66, 0xC6, 0xA3)
                )

                if (strategyList.isEmpty()){
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.height(24.dp))

                        Text(
                            text = "등록된 전략이 없습니다",
                            fontSize = 18.sp,
                        )

                        Spacer(modifier = Modifier.height(30.dp))

                        Button(
                            modifier = Modifier.drawColoredShadow(
                                alpha = 0.3f,
                                borderRadius = 22.dp,
                                offsetY = 3.dp
                            ),
                            onClick = { onNextButtonClicked() },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0x48, 0x48, 0x48)
                            ),
                        ) {
                            Text(
                                text = "새 전략 추가  ",
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )

                            Icon(
                                Icons.Filled.Add,
                                contentDescription = "Localized description",
                                modifier = Modifier.size(32.dp)
                            )
                        }
                        Divider(
                            modifier = Modifier.padding(top = 30.dp, start = 16.dp, end = 16.dp),
                            thickness = 1.dp,
                            color = Color(0x66, 0xC6, 0xA3)
                        )
                    }
                } else {
                    strategyList.forEachIndexed { index, it ->
                        if (index > 0){
                            Divider(
                                modifier = Modifier.padding(top = 10.dp, start = 16.dp, end = 16.dp),
                                thickness = 1.dp,
                                color = Color(0xe7, 0xe7, 0xe7)
                            )
                        }

                        Row(
                            modifier = Modifier.padding(start = 16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                modifier = Modifier
                                    .padding(top = 10.dp),
                                text = it.productName,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )

                            Spacer(modifier = Modifier.width(230.dp))

                            Text(
                                modifier = Modifier
                                    .padding(top = 10.dp,start = 5.dp),
                                text = it.productNumber.toString(),
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                                textAlign = TextAlign.Right
                            )

                            Spacer(modifier = Modifier.width(24.dp))

                            Text(
                                modifier = Modifier
                                    .padding(top = 10.dp, start = 2.dp)
                                    .width(40.dp),
                                text = it.productRate.toString()+"%",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                                textAlign = TextAlign.Right
                            )
                        }
                    }
                    Divider(
                        modifier = Modifier.padding(top = 10.dp, start = 16.dp, end = 16.dp),
                        thickness = 1.dp,
                        color = Color(0x66, 0xC6, 0xA3)
                    )
                }

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Spacer(modifier = Modifier.height(30.dp))

                    Text(
                        text = "전략을 100% 다 채우시면 포트폴리오를",
                        color = Color(0x9d, 0x9d,0x9d)
                    )
                    Text(
                        text = "제출 하실 수 있습니다",
                        color = Color(0x9d, 0x9d,0x9d)
                    )
                }

                Spacer(modifier = Modifier.height(160.dp))
            }

            Column(){
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 16.dp),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Button(
                        modifier = Modifier.drawColoredShadow(
                            alpha = 0.2f,
                            borderRadius = 32.dp,
                            offsetX = 3.dp,
                            offsetY = 3.dp
                        ),
                        onClick = { onNextButtonClicked() },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF, 0x77, 0x59)
                        ),
                        shape = CircleShape,
                        contentPadding = PaddingValues(top = 4.dp, bottom = 4.dp)
                    ) {
                        Icon(
                            Icons.Rounded.Add,
                            contentDescription = "Localized description",
                            modifier = Modifier.size(48.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, bottom = 86.dp),
                    onClick = {
                        portfolioDto.name = text
                        portfolioDto.strategies = strategyList
                        onInputButtonClicked()
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0x66, 0xc6, 0xa3)
                    ),
                    shape = RoundedCornerShape(5.dp),
                    contentPadding = PaddingValues(top = 4.dp, bottom = 4.dp)
                ) {
                    Text(
                        modifier = Modifier.padding(4.dp),
                        text = "제출",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}