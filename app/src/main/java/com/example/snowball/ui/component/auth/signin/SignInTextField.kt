package com.example.snowball.ui.component.auth.signin

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
import com.example.snowball.ui.screen.auth.signIn.SignInViewModel
import com.example.snowball.ui.screen.auth.signUp.SignUpViewModel
import com.example.snowball.ui.theme.MainBlack
import com.example.snowball.ui.theme.MainBlack50

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInTextField(
    signInViewModel: SignInViewModel
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
            value = signInViewModel.email.value,
            setValue = signInViewModel.setEmail,
            placeholder = "이메일을 입력해주세요!",
            keyboardType = KeyboardType.Email
        )
        Spacer(modifier = Modifier.height(12.dp))
        CustomTextField(
            value = signInViewModel.password.value,
            setValue = signInViewModel.setPassword,
            placeholder = "비밀번호를 입력해주세요!",
            keyboardType = KeyboardType.Password
        )
    }
}