package com.nectar_demo.features.splash.navigation.actions

import androidx.navigation.NavHostController
import com.nectar_demo.features.login.route.LoginRoute
import com.nectar_demo.features.main.NavigationItem

interface SplashActions {

    val controller : NavHostController

    fun navigateToShop(){
        controller.navigate(NavigationItem.Shop.route)
    }

    fun navigateToLogin(){
        controller.navigate(LoginRoute.route)
    }
}