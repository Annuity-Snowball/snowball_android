package com.example.snowball.ui.component.auth.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.snowball.ui.screen.auth.signUp.SignUpViewModel
import com.example.snowball.ui.theme.MainBlack
import com.example.snowball.ui.theme.MainBlack50
import com.example.snowball.ui.theme.MainGrey

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpTextField(
    signUpViewModel: SignUpViewModel
){
    @Composable
    fun CustomTextField(
        value: String,
        setValue: (String) -> Unit,
        placeholder: String,
        keyboardType: KeyboardType
    ){
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = value,
            onValueChange = {
                setValue(it)
            },
            placeholder = { Text(text = placeholder, color = MainBlack50) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = MainBlack
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            visualTransformation = if (keyboardType == KeyboardType.Password){
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            }
        )
    }


    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        CustomTextField(
            value = signUpViewModel.email.value,
            setValue = signUpViewModel.setEmail,
            placeholder = "이메일을 입력해주세요!",
            keyboardType = KeyboardType.Email
        )
        Spacer(modifier = Modifier.height(12.dp))
        CustomTextField(
            value = signUpViewModel.password.value,
            setValue = signUpViewModel.setPassword,
            placeholder = "비밀번호를 입력해주세요!",
            keyboardType = KeyboardType.Password
        )
        Spacer(modifier = Modifier.height(12.dp))
        CustomTextField(
            value = signUpViewModel.username.value,
            setValue = signUpViewModel.setUsername,
            placeholder = "이름을 입력해주세요!",
            keyboardType = KeyboardType.Text
        )
    }
}