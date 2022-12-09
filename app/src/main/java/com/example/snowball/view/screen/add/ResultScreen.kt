package com.example.snowball.view.screen.add


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.snowball.model.DTO.PortfolioDto
import com.example.snowball.model.DTO.TestDTO
import com.example.snowball.R
import com.example.snowball.viewModels.service.RetrofitService
import com.google.gson.JsonObject
import com.himanshoe.charty.line.LineChart
import com.himanshoe.charty.line.model.LineData
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

internal val colors = listOf(Color(0xFFff7759), Color(0xFFff7759))

@Composable
fun resultScreen(
    onInputButtonClicked: () -> Unit,
    portfolioDto: PortfolioDto
) {
    val graphValue = if (portfolioDto.name == "test1") {
        listOf<LineData>(
            LineData(1.0f, 1000000.0f),
            LineData(2.0f, 1675263.0f),
            LineData(3.0f, 1911604.0f),
            LineData(4.0f, 3694732.0f),
            LineData(5.0f, 4067552.0f),
            LineData(6.0f, 5107135.0f),
            LineData(7.0f, 5264540.0f),
            LineData(8.0f, 5165705.0f)
        )
    } else {
        listOf<LineData>(
            LineData(1.0f, 1000000.0f),
            LineData(2.0f, 1718960.0f),
            LineData(3.0f, 2116925.0f),
            LineData(4.0f, 3778120.0f),
            LineData(5.0f, 4272337.0f),
            LineData(6.0f, 5439896.0f),
            LineData(7.0f, 5360137.0f),
            LineData(8.0f, 4909500.0f)
        )
    }
//    x, o 반대로함
    val tableValue = if (portfolioDto.name == "test1"){
//        포트폴리오 결과 : {'투입한 금액': 4600000, '포트폴리오 가치': 4830981.0, '총 수익률': 5.02,  '승률': 86.23} - 세제혜택 X
//        포트폴리오 결과 : {'투입한 금액': 4600000, '포트폴리오 가치': 5165705.0, '총 수익률': 12.3,  '승률': 90.58} - 세제헤택 0
        TestDTO(4600000, 4600000, 4830981.0f,5165705.0f, 5.02f, 12.3f, 86.23f, 90.58f)
    } else {
//        포트폴리오 결과 : {'투입한 금액': 4600000, '포트폴리오 가치': 4581802.0, '총 수익률': -0.4,  '승률': 90.58} - 세제혜택 X
//        포트폴리오 결과 : {'투입한 금액': 4600000, '포트폴리오 가치': 4909500.0, '총 수익률': 6.73,  '승률': 94.93}  - 세제헤택 0
        TestDTO(4600000, 4600000, 4581802.0f,4909500.0f, -0.4f, 6.73f, 90.58f, 94.93f)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp)
            .background(Color.White),
            verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            LineChart(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp, start = 16.dp, end = 16.dp, bottom = 30.dp)
                    .height(300.dp),
                colors = colors,
                lineData = graphValue
            )

            Divider(
                modifier = Modifier.padding(top = 10.dp),
                thickness = 2.dp,
                color = Color(0xFFff7759)
            )

            Row() {
                Spacer(modifier = Modifier.width(120.dp))
                Text(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .width(120.dp),
                    text = "세제혜택X",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFff7759)
                )

                Spacer(modifier = Modifier.width(50.dp))

                Text(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .width(120.dp),
                    text = "세제혜택O",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFff7759)
                )
            }

            Divider(
                modifier = Modifier.padding(top = 10.dp),
                thickness = 1.dp,
                color = Color(0xFFff7759)
            )


            Row(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .fillMaxWidth(),
            ) {
                Text(
                    modifier = Modifier
                        .padding(top = 10.dp),
                    text = "투입금액",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.width(35.dp))

                Text(
                    modifier = Modifier
                        .padding(top = 10.dp, start = 5.dp),
                    text = tableValue.allMoneyO.toString(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    textAlign = TextAlign.Right
                )

                Spacer(modifier = Modifier.width(100.dp))

                Text(
                    modifier = Modifier
                        .padding(top = 10.dp, start = 2.dp),
                    text = tableValue.allMoneyX.toString(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    textAlign = TextAlign.Right
                )
            }

            Divider(
                modifier = Modifier.padding(top = 10.dp),
                thickness = 1.dp,
                color = Color(0xe7, 0xe7, 0xe7)
            )

            Row(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .fillMaxWidth(),
            ) {
                Text(
                    modifier = Modifier
                        .padding(top = 10.dp),
                    text = "포폴가치",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.width(30.dp))

                Text(
                    modifier = Modifier
                        .padding(top = 10.dp, start = 5.dp),
                    text = tableValue.portValueO.toString(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    textAlign = TextAlign.Right
                )

                Spacer(modifier = Modifier.width(85.dp))

                Text(
                    modifier = Modifier
                        .padding(top = 10.dp, start = 2.dp),
                    text = tableValue.portValueX.toString(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    textAlign = TextAlign.Right
                )
            }

            Divider(
                modifier = Modifier.padding(top = 10.dp),
                thickness = 1.dp,
                color = Color(0xe7, 0xe7, 0xe7)
            )

            Row(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .fillMaxWidth(),
            ) {
                Text(
                    modifier = Modifier
                        .padding(top = 10.dp),
                    text = "총수익률",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.width(50.dp))

                Text(
                    modifier = Modifier
                        .padding(top = 10.dp, start = 5.dp),
                    text = tableValue.returnValueO.toString(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    textAlign = TextAlign.Right
                )

                Spacer(modifier = Modifier.width(144.dp))

                Text(
                    modifier = Modifier
                        .padding(top = 10.dp, start = 2.dp),
                    text = tableValue.returnValueX.toString(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    textAlign = TextAlign.Right
                )
            }

            Divider(
                modifier = Modifier.padding(top = 10.dp),
                thickness = 1.dp,
                color = Color(0xe7, 0xe7, 0xe7)
            )

            Row(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .fillMaxWidth(),
            ) {
                Text(
                    modifier = Modifier
                        .padding(top = 10.dp),
                    text = "    승률",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.width(60.dp))

                Text(
                    modifier = Modifier
                        .padding(top = 10.dp, start = 5.dp),
                    text = tableValue.winRateO.toString(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    textAlign = TextAlign.Right
                )

                Spacer(modifier = Modifier.width(130.dp))

                Text(
                    modifier = Modifier
                        .padding(top = 10.dp, start = 2.dp),
                    text = tableValue.winRateX.toString(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    textAlign = TextAlign.Right
                )
            }

            Divider(
                modifier = Modifier.padding(top = 10.dp),
                thickness = 1.dp,
                color = Color(0xFFff7759)
            )
        }
//
//        Button(
//            modifier = Modifier
//                .fillMaxWidth()
//                .align(alignment = Alignment.End)
//                .padding(bottom = 86.dp),
//            onClick = {
//                onInputButtonClicked()
//            },
//            colors = ButtonDefaults.buttonColors(
//                containerColor = colorResource(id = R.color.core_green)
//            ),
//            shape = RoundedCornerShape(5.dp),
//            contentPadding = PaddingValues(top = 4.dp, bottom = 4.dp)
//        ) {
//            Text(
//                modifier = Modifier.padding(4.dp),
//                text = "처음으로",
//                fontSize = 24.sp,
//                fontWeight = FontWeight.Bold
//            )
//        }

    }


    /*
    var onlyMoneyJsonObject: JsonObject = JsonObject()
    var withTaxResultJsonObject: JsonObject = JsonObject()
    var resultWithTaxResultJsonObject: JsonObject = JsonObject()
    var withOutTaxResultJsonObject: JsonObject = JsonObject()
    var resultWithOutTaxResultJsonObject: JsonObject = JsonObject()

    var onlyMoney: MutableList<String> = mutableListOf()
    var withTaxMoney: MutableList<String> = mutableListOf()
    var withOutTaxMoney: MutableList<String> = mutableListOf()

    var chartDateList: MutableList<String> = mutableListOf()

    val trigger = remember { mutableStateOf("") }

    Surface() {
        Column {
            Text(text = portfolioDto.name)
            Text(text = portfolioDto.strategies[0].productName)
            Log.e("this is portfolio", portfolioDto.toString())
            Text(text = portfolioDto.toString())

            LaunchedEffect(trigger) {

                RetrofitService.backTest.doBackTest(portfolioDto)
                    .enqueue(object : Callback<JsonObject> {
                        override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                            Log.e("this is failure!", t.toString())
                        }

                        override fun onResponse(
                            call: Call<JsonObject>,
                            response: Response<JsonObject>
                        ) {
                            onlyMoneyJsonObject =
                                response?.body()?.get("onlyMoney") as JsonObject
                            withTaxResultJsonObject =
                                response?.body()?.get("value_with_tax") as JsonObject
                            withOutTaxResultJsonObject =
                                response?.body()?.get("value_without_tax") as JsonObject
                            resultWithOutTaxResultJsonObject =
                                response?.body()?.get("value_without_tax") as JsonObject
                            resultWithOutTaxResultJsonObject =
                                response?.body()?.get("value_without_tax") as JsonObject

                            chartDateList = onlyMoneyJsonObject.keySet().toMutableList()

                            for (key in chartDateList) {
                                onlyMoney.add(onlyMoneyJsonObject[key].toString())
                                withTaxMoney.add(withTaxResultJsonObject[key].toString())
                                withOutTaxMoney.add(withOutTaxResultJsonObject[key].toString())
                            }

                            Log.e("this is success", chartDateList.toString())


                        }

                    })
                delay(5000)
                var inputMoney = resultWithTaxResultJsonObject.get("투입한 금액").toString()
                Log.d("well doing??", "$inputMoney")
            }
        }
    }

     */
}


