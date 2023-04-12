package com.example.snowball.ui.component.add.result

import android.icu.text.SimpleDateFormat
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.snowball.ui.screen.add.portfolio_input.PortfolioInputScreenViewModel
import com.example.snowball.ui.theme.MainBlack
import com.example.snowball.ui.theme.MainGreen
import com.example.snowball.ui.theme.MainOrange
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter
import java.util.*

@Composable
fun DailyBenefitChart(

) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            modifier = Modifier
                .padding(vertical = 16.dp),
            text = "일별 수익률",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
    }

    AndroidView(
        factory = { context ->
            val chart = LineChart(context)

            chart.extraBottomOffset = 15f
            chart.description.isEnabled = false

            val legend = chart.legend

            legend.verticalAlignment = Legend.LegendVerticalAlignment.BOTTOM
            legend.horizontalAlignment = Legend.LegendHorizontalAlignment.CENTER
            legend.form = Legend.LegendForm.CIRCLE
            legend.formSize = 10f
            legend.textSize = 13f
            legend.textColor = MainBlack.hashCode()
            legend.orientation = Legend.LegendOrientation.VERTICAL
            legend.setDrawInside(false)
            legend.yEntrySpace = 5f
            legend.isWordWrapEnabled = true
            legend.xOffset = 80f
            legend.yOffset = 20f
            legend.calculatedLineSizes

            val xAxis = chart.xAxis

            xAxis.setDrawAxisLine(false)
            xAxis.setDrawGridLines(false)
            xAxis.position = XAxis.XAxisPosition.BOTTOM
            xAxis.granularity = 1f
            xAxis.textSize = 10f
            xAxis.textColor = MainBlack.hashCode()

            xAxis.valueFormatter = object : ValueFormatter() {
                private val dateFormat = SimpleDateFormat("yyyy-MM", Locale.getDefault())

                override fun getFormattedValue(value: Float): String {
                    val dateMillis = value.toLong()
                    val date = Date(dateMillis)
                    return dateFormat.format(date)
                }
            }

            val yLeftAxis = chart.axisLeft
            yLeftAxis.setDrawAxisLine(false)
            yLeftAxis.setDrawLabels(false)
            yLeftAxis.axisLineWidth = 2f

            val yRightAxis = chart.axisRight

            yRightAxis.textSize = 10f
            yRightAxis.textColor = MainBlack.hashCode()
            yRightAxis.setDrawAxisLine(false)
            yRightAxis.axisLineWidth = 2f

//            yRightAxis.valueFormatter = object : ValueFormatter() {
//                override fun getFormattedValue(value: Float): String {
//                    return when {
//                        value >= 1_000_000 -> "%dm".format((value / 1_000_000).toInt())
//                        value >= 1_000 -> "%dk".format((value / 1_000).toInt())
//                        else -> "%d".format(value.toInt())
//                    }
//                }
//            }

            val dailyBenefitEntries = mutableListOf<Entry>()
            val dailyBenefitElements = parseJsonToEntries(
                PortfolioInputScreenViewModel.BackTestResult.result.value.result_with_tax.getAsJsonObject("일별 수익률")
            )
            dailyBenefitEntries.addAll(dailyBenefitElements)

            val dailyBenefitDataSet = LineDataSet(dailyBenefitEntries, "수익률").apply {
                lineWidth = 2f
                setDrawCircles(false)
                setDrawValues(false)
                setDrawHorizontalHighlightIndicator(false)
                setDrawHighlightIndicators(false)
                color = MainGreen.hashCode()
            }

            val lineData = LineData(dailyBenefitDataSet)

            chart.data = lineData
            chart.xAxis.position = XAxis.XAxisPosition.BOTTOM
            chart.invalidate()

            chart
        },
        modifier = androidx.compose.ui.Modifier
            .width(360.dp)
            .height(360.dp)
    )
}