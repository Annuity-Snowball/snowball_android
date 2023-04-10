package com.example.snowball.ui.component.add.select

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ChevronRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.snowball.ui.screen.add.select.SelectScreenViewModel

@Composable
fun SelectItems(
    selectScreenViewModel: SelectScreenViewModel
) {
    LazyColumn() {
        items(selectScreenViewModel.strategyItemList.value){ item ->
            SelectItem(
                itemName = item,
                selectedItem = selectScreenViewModel.selectedItem,
                setSelectedItem = selectScreenViewModel.setSelectedItem
            )
        }
    }
}

@Composable
fun SelectItem(
    itemName: String,
    selectedItem: MutableState<String>,
    setSelectedItem: (String) -> Unit
) {
    val containerColor = if(itemName == selectedItem.value) {
        Color(0xFF, 0x77, 0x59)
    } else {
        Color(255, 255, 255)
    }

    val contentColor = if(itemName == selectedItem.value) {
        Color.White
    } else {
        Color.Black
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .selectable(
                selected = (selectedItem.value == itemName),
                onClick = {
                    setSelectedItem(itemName)
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
            text = itemName,
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