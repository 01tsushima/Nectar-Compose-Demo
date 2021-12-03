package com.nectar_demo.features.login.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.nectar_demo.common.navigation.NavActions
import com.nectar_demo.features.login.LoginScreen
import com.nectar_demo.features.login.route.LoginRoute

fun NavGraphBuilder.loginScreenNav(
    navAction: NavActions,
    hideBottomBar: () -> Unit
) {
    composable(LoginRoute.route) {
        LoginScreen()
    }
}