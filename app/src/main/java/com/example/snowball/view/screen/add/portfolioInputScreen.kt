package com.example.snowball.view.screen.add

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Cancel
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.snowball.R
import com.example.snowball.model.DTO.PortfolioDto
import com.example.snowball.model.DTO.StrategyDto

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun portfolioInputScreen(
    onInputButtonClicked: () -> Unit,
    portfolioDto: PortfolioDto,
){
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            var idText by remember { mutableStateOf("") }
            var startDate by remember { mutableStateOf("") }
            var endDate by remember { mutableStateOf("") }
            var rebalancingDuration by remember { mutableStateOf("") }
            var inputMoney by remember { mutableStateOf("") }
            var startMoney by remember { mutableStateOf("") }
            var inputWay by remember { mutableStateOf("") }

//            idText = "1"
//            startDate = "2017-10-13"
//            endDate = "2020-10-13"
//            rebalancingDuration = "6"
//            inputMoney = "30000"
//            startMoney = "100000"
//            inputWay = "0"

            Column(
                modifier = Modifier
                    .background(Color.White)
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                idText = customOutlinedTextField(labelName = "id", "num")
                Spacer(modifier = Modifier.height(20.dp))
                startDate = customOutlinedTextField(labelName = "시작 일자", "str")
                Spacer(modifier = Modifier.height(20.dp))
                endDate = customOutlinedTextField(labelName = "종료 일자", "str")
                Spacer(modifier = Modifier.height(20.dp))
                rebalancingDuration = customOutlinedTextField(labelName = "리밸런싱 주기", "num")
                Spacer(modifier = Modifier.height(20.dp))
                inputMoney = customOutlinedTextField(labelName = "입력 금액", "num")
                Spacer(modifier = Modifier.height(20.dp))
                startMoney = customOutlinedTextField(labelName = "초기 금액", "num")
                Spacer(modifier = Modifier.height(20.dp))
                inputWay = customOutlinedTextField(labelName = "입력 방법", "num")
                Spacer(modifier = Modifier.height(20.dp))
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(alignment = Alignment.End)
                    .padding(bottom = 86.dp),
                onClick = {
                    onInputButtonClicked()
                    portfolioDto.id = idText.toInt()
                    portfolioDto.startDate = startDate
                    portfolioDto.endDate = endDate
                    portfolioDto.rebalancingDuration = rebalancingDuration.toInt()
                    portfolioDto.inputMoney = inputMoney.toInt()
                    portfolioDto.strategyNumber = portfolioDto.strategies.size
                    portfolioDto.startMoney = startMoney.toInt()
                    portfolioDto.inputWay = inputWay.toInt()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.core_orange)
                ),
                shape = RoundedCornerShape(5.dp),
                contentPadding = PaddingValues(top = 4.dp, bottom = 4.dp)
            ) {
                Text(
                    modifier = Modifier.padding(4.dp),
                    text = "백테스트",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun customOutlinedTextField(labelName: String, type: String):String{
    var textValue by remember { mutableStateOf("") }
//    textValue = ""
    val icon = @Composable{
        IconButton(
            onClick = {
                textValue = ""
            },
        ) {
            Icon(
                Icons.Outlined.Cancel,
                contentDescription = "",
            )
        }
    }
    OutlinedTextField(
        value = textValue,
        onValueChange = {
            textValue = it
        },
        modifier = Modifier.fillMaxWidth(),
        trailingIcon = if (textValue.isNotBlank()) icon else null,
        label = {
            Text(
                text = labelName,
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
            keyboardType =  if (type == "num") {
                KeyboardType.Decimal
            } else {
                KeyboardType.Text
            }
        )
    )
    return textValue
}