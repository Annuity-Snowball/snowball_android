package com.example.snowball.ui.component.add.select

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.rounded.ChevronRight
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.snowball.model.add.TooltipText
import com.example.snowball.ui.screen.add.select.SelectScreenViewModel
import com.example.snowball.ui.theme.LightGrey
import com.example.snowball.ui.theme.MainBlack
import com.example.snowball.ui.theme.MainGreen
import com.example.snowball.ui.theme.MainGrey
import kotlinx.coroutines.launch

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

@OptIn(ExperimentalMaterial3Api::class)
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
        verticalAlignment = Alignment.CenterVertically
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

        if(
            SelectScreenViewModel.StrategyItemNames.valuePointer.contains(itemName) ||
            SelectScreenViewModel.StrategyItemNames.fundamentalPointer.contains(itemName)
        ) {
            val scope = rememberCoroutineScope()
            val tooltipState = rememberRichTooltipState(isPersistent = true)

            RichTooltipBox(
                modifier = Modifier.border(
                    width = 1.dp,
                    color = MainGrey,
                    shape = ShapeDefaults.Medium
                ),
                title = { Text(text = itemName, fontWeight = FontWeight.Bold) },
                text = {
                    Text(text = TooltipText.textMap[itemName]!!)
                },
                tooltipState = tooltipState,
                action = {
                    TextButton(
                        onClick = { scope.launch { tooltipState.dismiss() }}
                    ) { Text(text = "닫기", color = MainGreen) }
                },
                colors = TooltipDefaults.richTooltipColors(
                    containerColor = Color.White,
                    contentColor = MainBlack,
                    titleContentColor = MainBlack,
                    actionContentColor = MainGreen
                )
            ) {}

            IconButton(onClick = { scope.launch { tooltipState.show() } }) {
                Icon(
                    Icons.Outlined.Info,
                    contentDescription = "more info",
                    tint = contentColor
                )
            }
        } else {
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
}