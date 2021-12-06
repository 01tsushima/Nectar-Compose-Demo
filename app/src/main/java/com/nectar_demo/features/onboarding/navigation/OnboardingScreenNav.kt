package com.nectar_demo.features.onboarding.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.nectar_demo.common.navigation.NavActions
import com.nectar_demo.features.onboarding.OnboardingScreen
import com.nectar_demo.features.onboarding.route.OnboardingRoute

fun NavGraphBuilder.onboardingScreenNav(
    navAction: NavActions
) {
    composable(OnboardingRoute.route) {
        OnboardingScreen {
            navAction.navigateToLogin()
        }
    }
}