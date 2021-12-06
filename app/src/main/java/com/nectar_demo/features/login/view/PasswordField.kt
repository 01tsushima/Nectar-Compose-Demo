package com.nectar_demo.features.login.view

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.nectar_demo.R
import com.nectar_demo.features.login.LoginScreenState
import com.nectar_demo.features.login.LoginViewModel
import com.nectar_demo.ui.theme.black
import com.nectar_demo.ui.theme.grey
import com.nectar_demo.ui.theme.midnightExpress
import com.nectar_demo.ui.theme.typography

@Composable
fun passwordField(state: LoginScreenState, viewModel: LoginViewModel) {
    TextField(
        label = {
            Text(
                text = stringResource(id = R.string.password),
                style = typography.body1,
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        textStyle = typography.h2,
        value = state.password,
        onValueChange = viewModel::updatePassword,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 30.dp),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = colorResource(id = android.R.color.transparent),
            textColor = black,
            cursorColor = black,
            placeholderColor = grey
        ),
        trailingIcon = {
            IconButton(onClick = viewModel::togglePassword) {
                Icon(
                    painter = painterResource(
                        id = if (state.isPasswordVisible) R.drawable.ic_passowrd
                        else R.drawable.ic_password_hidden
                    ),
                    contentDescription = "trailingIcon",
                    tint = midnightExpress
                )
            }
        },
        visualTransformation = if (state.isPasswordVisible) VisualTransformation.None
        else PasswordVisualTransformation()
    )
}