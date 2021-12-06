package com.nectar_demo.features.login

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.nectar_demo.R
import com.nectar_demo.features.login.navigation.LoginEvent
import com.nectar_demo.features.login.view.emailField
import com.nectar_demo.features.login.view.forgotPassword
import com.nectar_demo.features.login.view.passwordField
import com.nectar_demo.features.login.view.signUpButton
import com.nectar_demo.ui.theme.*

@Composable
fun LoginScreen(
    viewModel: LoginViewModel,
    onEvent: (LoginEvent) -> Unit = {}
) {
    val systemUiController = rememberSystemUiController()
    val state: LoginScreenState by viewModel.userAuthStateFlow.collectAsState()
    systemUiController.isStatusBarVisible = true
    systemUiController.setStatusBarColor(white)

    val context = LocalContext.current

    state.isAuth?.let { onEvent(it) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.scrollable(rememberScrollState(), orientation = Orientation.Vertical)) {
            Image(
                painter = painterResource(id = R.drawable.ic_carrot),
                contentDescription = "topImage",
                modifier = Modifier
                    .padding(top = 28.dp)
                    .align(Alignment.CenterHorizontally),
                contentScale = ContentScale.FillWidth
            )
            Text(
                text = stringResource(id = R.string.login),
                Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 50.dp, start =
                        24.dp, end = 24.dp
                    ),
                style = typography.h1,
            )
            Text(
                text = stringResource(id = R.string.fill_creds),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 15.dp),
                style = typography.body1,
            )
            emailField(state = state, viewModel = viewModel)
            passwordField(state, viewModel)
            Box(
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(top = 20.dp, end = 16.dp),
            ) {
                forgotPassword {
                    Toast.makeText(context, "hello", Toast.LENGTH_LONG).show()
                }
            }
            Button(
                onClick = viewModel::doLogin,
                colors = ButtonDefaults.textButtonColors(
                    backgroundColor = oceanGreen
                ),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 30.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.login),
                    style = typography.button,
                    modifier = Modifier.padding(vertical = 10.dp)
                )
            }
            Row(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    stringResource(id = R.string.dont_have_account),
                    style = typography.body2
                )
                signUpButton {
                    Toast.makeText(context, "hello", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}