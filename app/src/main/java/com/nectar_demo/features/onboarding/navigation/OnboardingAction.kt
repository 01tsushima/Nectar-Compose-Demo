package com.nectar_demo.features.onboarding.navigation

import androidx.navigation.NavHostController
import com.nectar_demo.features.login.route.LoginRoute

interface OnboardingAction {

    val controller: NavHostController

    fun navigateToLogin() {
        controller.navigate(LoginRoute.route)
    }
}