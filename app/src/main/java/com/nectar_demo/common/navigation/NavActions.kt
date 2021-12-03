package com.nectar_demo.common.navigation

import androidx.navigation.NavHostController
import com.nectar_demo.features.splash.navigation.actions.SplashActions

class NavActions(
    override val controller: NavHostController,
) : SplashActions {

    val navigateToUp: () -> Unit = {
        controller.navigateUp()
    }
}