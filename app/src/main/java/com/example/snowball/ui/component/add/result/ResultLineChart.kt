package com.example.snowball.ui.component.add.result

import android.icu.text.SimpleDateFormat
import android.util.Log
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.snowball.ui.screen.add.portfolio_input.PortfolioInputScreenViewModel
import com.example.snowball.ui.theme.SnowballTheme
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import java.util.*


@Composable
fun ResultLineChart(

) {
    AndroidView(
        factory = { context ->
        val chart = LineChart(context)
        val entries = mutableListOf<Entry>()
        val elements = parseJsonToEntries()
        entries.addAll(elements)
//        for (i in PortfolioInputScreenViewModel.BackTestResult.result.value.onlyMoney.asJsonArray) {
//            entries.add(Entry(i., (i * i).toFloat()))
//        }

        val dataSet = LineDataSet(entries, "Example Line Chart")
        val lineData = LineData(dataSet)

        chart.data = lineData
        chart.xAxis.position = XAxis.XAxisPosition.BOTTOM
        chart.invalidate()

        chart
    },
        modifier = androidx.compose.ui.Modifier
            .width(360.dp)
            .height(700.dp)
    )
}

fun parseJsonToEntries(): List<Entry> {
    val jsonObject = PortfolioInputScreenViewModel.BackTestResult.result.value.onlyMoney

    val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val entries = mutableListOf<Entry>()

    for (key in jsonObject.keySet()) {
        val dateMillis = dateFormat.parse(key)?.time?.toFloat() ?: 0f
        val value = jsonObject.get(key)
        Log.i("AddScreen.ResultScreen", "key: $key, value : $value")
        entries.add(Entry(dateMillis, value.asFloat))
    }

    return entries.sortedBy { it.x }
}

@Preview
@Composable
fun ResultLineChartPreview(){
    SnowballTheme {
        Surface {
            ResultLineChart()
        }
    }
}