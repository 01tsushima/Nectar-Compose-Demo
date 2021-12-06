package com.nectar_demo.features.splash.navigation.actions

import androidx.navigation.NavHostController
import com.nectar_demo.features.login.route.LoginRoute
import com.nectar_demo.features.main.NavigationItem
import com.nectar_demo.features.onboarding.route.OnboardingRoute

interface SplashActions {

    val controller : NavHostController

    fun navigateToShop(){
        controller.navigate(NavigationItem.Shop.route)
    }

    fun navigateToOnBoarding(){
        controller.navigate(OnboardingRoute.route)
    }
}