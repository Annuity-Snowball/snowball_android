package com.example.snowball.ui.component.add.select

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.HelpOutline
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.snowball.ui.component.modifierExtension.drawColoredShadow
import com.example.snowball.ui.screen.SnowballAppViewModel
import com.example.snowball.ui.screen.add.select.SelectScreenViewModel
import com.example.snowball.ui.theme.MainBlack
import com.example.snowball.view.TopAppBarTitle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectTopBar(
    selectScreenViewModel: SelectScreenViewModel,
    onBack: () -> Unit,
){
    TopAppBar(
        modifier = Modifier
            .drawColoredShadow(offsetX = 2.dp),
        title = { Text(text = selectScreenViewModel.title.value) },
        navigationIcon = {
            BackIconBtn(
                onBack = onBack,
                selectScreenViewModel = selectScreenViewModel
            )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color(255, 255, 255, 255)
        )
    )
}

@Composable
fun BackIconBtn(
    onBack: () -> Unit,
    selectScreenViewModel: SelectScreenViewModel,
){
    IconButton(onClick = {
        selectScreenViewModel.setStrategyItemListOnBack()
        onBack()
        if(selectScreenViewModel.depth.value == 0) {
            SnowballAppViewModel.BottomBarState.toggleBottomBar()
        } else {
            selectScreenViewModel.minusDepth()
        }
    }) {
        Icon(
            imageVector = Icons.Rounded.ArrowBack,
            contentDescription = "Go Back",
            tint = MainBlack
        )
    }
}

