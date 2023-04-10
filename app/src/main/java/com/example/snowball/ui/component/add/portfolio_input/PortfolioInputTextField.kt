package com.example.snowball.ui.component.add.portfolio_input

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.snowball.ui.theme.MainOrange

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PortfolioInputTextField(
    value: String,
    setValue: (String) -> Unit,
    label: String,
    keyboardType: KeyboardType
) {
    OutlinedTextField(
        value = value,
        onValueChange = {
            setValue(it)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MainOrange,
            focusedLabelColor = MainOrange
        ),
        label = { Text(text = label) }
    )
}