package com.nectar_demo.features.splash.navigation.navigation

import androidx.hilt.navigation.compose.hiltViewModel

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.nectar_demo.common.navigation.NavActions
import com.nectar_demo.features.splash.SplashEvents
import com.nectar_demo.features.splash.SplashScreen
import com.nectar_demo.features.splash.navigation.route.SplashScreenRoute

fun NavGraphBuilder.splashScreenNav(
    navAction: NavActions,
    hideBottomBar:()->Unit
) {
    composable(SplashScreenRoute.route) {
        SplashScreen(viewModel = hiltViewModel()){event->
            when(event){
                SplashEvents.RedirectToAuthorized->navAction.navigateToShop()
                SplashEvents.RedirectToLogin->navAction.navigateToLogin()
            }
        }
    }
}