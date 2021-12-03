package com.nectar_demo.features.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nectar_demo.ui.theme.background

@Composable
fun LoginScreen() {
    Scaffold(
        backgroundColor = background
    )
    {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(text = "login")
        }
    }
}