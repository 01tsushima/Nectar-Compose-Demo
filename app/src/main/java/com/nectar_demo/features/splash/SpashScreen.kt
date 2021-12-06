package com.nectar_demo.features.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.nectar_demo.R
import com.nectar_demo.ui.theme.oceanGreen


@Composable
fun SplashScreen(
    viewModel: SplashViewModel,
    onEvent: (SplashEvents) -> Unit = {}
) {
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }
    val systemUiController = rememberSystemUiController()

    val authStateFlow: SplashScreenState by viewModel.userAuthStateFlow.collectAsState()

    when (authStateFlow.isAuthorized) {
        true -> onEvent(SplashEvents.RedirectToAuthorized)
        false -> onEvent(SplashEvents.RedirectToLogin)
        null -> {}
    }
    systemUiController.setStatusBarColor(color = oceanGreen)
    // AnimationEffect
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                })
        )
    }

    Scaffold(backgroundColor = oceanGreen) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(),
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = "Logo",
                modifier = Modifier.scale(scale.value)
            )
        }
    }
}