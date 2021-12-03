package com.nectar_demo.features.splash

sealed class SplashEvents {

    object RedirectToLogin : SplashEvents()
    object RedirectToAuthorized : SplashEvents()
}