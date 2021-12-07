package com.nectar_demo.features.splash.navigation.actions

import androidx.navigation.NavHostController
import com.nectar_demo.features.onboarding.route.OnboardingRoute
import com.nectar_demo.features.shop.ui.route.ShopScreenRoute

interface SplashActions {

    val controller: NavHostController

    fun navigateToShop() {
        controller.navigate(ShopScreenRoute.route)
    }

    fun navigateToOnBoarding() {
        controller.navigate(OnboardingRoute.route)
    }
}