package com.example.snowball.ui.component.add.portfolio_input

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.snowball.ui.screen.add.portfolio_input.PortfolioInputScreenViewModel
import com.example.snowball.ui.theme.MainGreen
import com.example.snowball.ui.theme.MainGreenTransparent
import com.example.snowball.ui.theme.MainOrange
import com.example.snowball.ui.theme.MainOrangeTransparent
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GetDateInfo(
    portfolioInputScreenViewModel: PortfolioInputScreenViewModel
) {
    val now = LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli()

    val dateRangePickerState = rememberDateRangePickerState(
        initialSelectedStartDateMillis = now
    )
    DateRangePicker(
        modifier = Modifier.
            height(500.dp),
        state = dateRangePickerState,
        showModeToggle = false,
        title = {
            Text(
                modifier = Modifier
                    .padding(bottom = 10.dp),
                text = "날짜 설정",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        },
        colors = DatePickerDefaults.colors(
            selectedDayContainerColor = MainOrange,
            dayInSelectionRangeContainerColor = MainOrangeTransparent,
            todayDateBorderColor = MainOrange,
            dividerColor = MainGreenTransparent
        )
    )

    dateRangePickerState.selectedStartDateMillis?.let {
        val date = dateFormattingOutput(it)
        portfolioInputScreenViewModel.setStartDate(date)
    }

    dateRangePickerState.selectedEndDateMillis?.let {
        val date = dateFormattingOutput(it)
        portfolioInputScreenViewModel.setEndDate(date)
    }
}

fun dateFormattingOutput(date: Long):String {
    val instant = Instant.ofEpochMilli(date)
    val localDateTime = LocalDateTime.ofInstant(instant, ZoneOffset.UTC)
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

    return localDateTime.format(formatter)
}