package com.nectar_demo.common.navigation

import androidx.navigation.NavHostController
import com.nectar_demo.features.onboarding.navigation.OnboardingAction
import com.nectar_demo.features.splash.navigation.actions.SplashActions

class NavActions(
    override val controller: NavHostController,
) : SplashActions,OnboardingAction {

    val navigateToUp: () -> Unit = {
        controller.navigateUp()
    }
}