package com.nectar_demo.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.paging.ExperimentalPagingApi
import com.google.accompanist.pager.ExperimentalPagerApi
import com.nectar_demo.common.navigation.NavActions
import com.nectar_demo.features.login.navigation.loginScreenNav
import com.nectar_demo.features.main.NavigationItem
import com.nectar_demo.features.onboarding.navigation.onboardingScreenNav
import com.nectar_demo.features.shop.ui.navigation.shopScreenNav
import com.nectar_demo.features.splash.navigation.navigation.splashScreenNav

@ExperimentalPagingApi
@ExperimentalPagerApi
@ExperimentalComposeUiApi
@Composable
fun NavGraph(
    navController: NavHostController
) {

    val viewModel: MainViewModel = hiltViewModel()

    val navActions = remember(navController) {
        NavActions(navController)
    }

    NavHost(navController, startDestination = viewModel.getSplashRoute()) {

        shopScreenNav(navAction = navActions)

        composable(NavigationItem.Explore.route) {
            DefaultScreen(item = NavigationItem.Explore)
        }
        composable(NavigationItem.Cart.route) {
            DefaultScreen(item = NavigationItem.Cart)
        }
        composable(NavigationItem.Favourite.route) {
            DefaultScreen(item = NavigationItem.Favourite)
        }
        composable(NavigationItem.Account.route) {
            DefaultScreen(item = NavigationItem.Account)
        }

        splashScreenNav(navAction = navActions)
        loginScreenNav(navAction = navActions)
        onboardingScreenNav(navAction = navActions)
    }
}

@Composable
fun DefaultScreen(item: NavigationItem) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(id = item.title))
    }
}