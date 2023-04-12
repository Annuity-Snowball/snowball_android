package com.example.snowball.ui.component.add.result

import android.icu.text.SimpleDateFormat
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.snowball.ui.screen.add.portfolio_input.PortfolioInputScreenViewModel
import com.example.snowball.ui.theme.*
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter
import com.google.gson.JsonObject
import java.util.*


@Composable
fun ResultLineChart(

) {
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

            yRightAxis.valueFormatter = object : ValueFormatter() {
                override fun getFormattedValue(value: Float): String {
                    return when {
                        value >= 1_000_000 -> "%dm".format((value / 1_000_000).toInt())
                        value >= 1_000 -> "%dk".format((value / 1_000).toInt())
                        else -> "%d".format(value.toInt())
                    }
                }
            }

            val onlyMoneyEntries = mutableListOf<Entry>()
            val onlyMoneyElements = parseJsonToEntries(PortfolioInputScreenViewModel.BackTestResult.result.value.onlyMoney)
            onlyMoneyEntries.addAll(onlyMoneyElements)

            val onlyMoneyDataSet = LineDataSet(onlyMoneyEntries, "현금").apply {
                lineWidth = 2f
                setDrawCircles(false)
                setDrawValues(false)
                setDrawHorizontalHighlightIndicator(false)
                setDrawHighlightIndicators(false)
                color = MainBlack50.hashCode()
            }

            val valueWithOutTaxEntries = mutableListOf<Entry>()
            val valueWithOutTaxElements = parseJsonToEntries(PortfolioInputScreenViewModel.BackTestResult.result.value.value_without_tax)
            valueWithOutTaxEntries.addAll(valueWithOutTaxElements)

            val valueWithOutTaxDataSet = LineDataSet(valueWithOutTaxEntries, "세제혜택x").apply {
                lineWidth = 2f
                setDrawCircles(false)
                setDrawValues(false)
                setDrawHorizontalHighlightIndicator(false)
                setDrawHighlightIndicators(false)
                color = MainGreen.hashCode()
            }

            val valueWithTaxEntries = mutableListOf<Entry>()
            val valueWithTaxElements = parseJsonToEntries(PortfolioInputScreenViewModel.BackTestResult.result.value.value_with_tax)
            valueWithTaxEntries.addAll(valueWithTaxElements)

            val valueWithTaxDataSet = LineDataSet(valueWithTaxEntries, "세제혜택o").apply {
                lineWidth = 2f
                setDrawCircles(false)
                setDrawValues(false)
                setDrawHorizontalHighlightIndicator(false)
                setDrawHighlightIndicators(false)
                color = MainOrange.hashCode()
            }

            val lineData = LineData(onlyMoneyDataSet, valueWithOutTaxDataSet, valueWithTaxDataSet)

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

fun parseJsonToEntries(
    jsonObject: JsonObject
): List<Entry> {

    val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val entries = mutableListOf<Entry>()

    for (key in jsonObject.keySet()) {
        val dateMillis = dateFormat.parse(key)?.time?.toFloat() ?: 0f
        val value = jsonObject.get(key)
        entries.add(Entry(dateMillis, value.asFloat))
    }

    return entries.sortedBy { it.x }
}