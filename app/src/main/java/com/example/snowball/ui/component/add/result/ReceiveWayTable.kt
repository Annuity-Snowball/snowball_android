package com.example.snowball.ui.component.add.result

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.snowball.ui.screen.add.portfolio_input.PortfolioInputScreenViewModel
import com.example.snowball.ui.theme.MainBlack
import com.example.snowball.ui.theme.MainGreenTransparent
import com.example.snowball.ui.theme.MainGrey
import com.example.snowball.ui.theme.MainOrangeTransparent

@Composable
fun ReceiveWayTable() {

    val scrollState = rememberScrollState()

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            modifier = Modifier
                .padding(vertical = 16.dp),
            text = "수령방법",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        ReceiveTableHeader()
        ReceiveTableBody()
    }

}

@Composable
fun ReceiveTableHeader(
) {
    LazyRow(
        modifier = Modifier
            .background(MainOrangeTransparent)
    ) {
        item(
            content = {
                TableCell(text = "    ", borderColor = MainOrangeTransparent, width = 50 )
                for (i in 1..10) {
                    TableCell(text = "${i}년차 수령금액", borderColor = MainOrangeTransparent )
                }
            }
        )
    }
}

@Composable
fun ReceiveTableBody(
) {
    PortfolioInputScreenViewModel.BackTestResult.result.value.apply {
        LazyRow {
            item(
                content = {
                    TableCell(text = "A방안", width = 50 )
                    for (i in 1..10) {
                        TableCell(text = "${receive_with_tax[0].asJsonObject["${i}년차 수령금액"]}원")
                    }
                }
            )
        }
        LazyRow {
            item(
                content = {
                    TableCell(text = "B방안", width = 50 )
                    for (i in 1..10) {
                        TableCell(text = "${receive_with_tax[1].asJsonObject["${i}년차 수령금액"]}원")
                    }
                }
            )
        }
    }
}

@Composable
fun LazyItemScope.TableCell(
    text: String,
    fontSize: Int = 12,
    borderColor: Color = MainGrey,
    width: Int = 100
) {
    Text(
        text = text,
        modifier = Modifier
            .border(1.dp, borderColor)
            .width(width.dp)
            .padding(6.dp),
        color = MainBlack,
        fontSize = fontSize.sp,
        fontWeight = FontWeight.Bold
    )
}