package com.nectar_demo.features.login.view

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.nectar_demo.R
import com.nectar_demo.features.login.LoginScreenState
import com.nectar_demo.features.login.LoginViewModel
import com.nectar_demo.ui.theme.black
import com.nectar_demo.ui.theme.grey
import com.nectar_demo.ui.theme.typography

@Composable
fun emailField(state:LoginScreenState,viewModel:LoginViewModel){
    TextField(
        label = {
            Text(
                text = stringResource(id = R.string.email),
                style = typography.body1,
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        textStyle = typography.h2,
        value = state.login,
        onValueChange = viewModel::updateLogin,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 40.dp),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = colorResource(
                id = android.R.color
                    .transparent
            ),
            textColor = black,
            cursorColor = black,
            placeholderColor = grey
        )
    )
}