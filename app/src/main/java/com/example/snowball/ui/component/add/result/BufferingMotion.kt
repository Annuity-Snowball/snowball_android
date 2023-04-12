package com.example.snowball.ui.component.add.result

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.snowball.ui.theme.MainOrange

@Composable
fun BufferingMotion() {
    Box(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.padding(top = 400.dp))
        CircularProgressIndicator(
            modifier = Modifier
                .align(Alignment.Center),
            color = MainOrange
        )
    }
}