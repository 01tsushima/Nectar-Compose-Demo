package com.nectar_demo.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.nectar_demo.common.navigation.NavActions
import com.nectar_demo.features.login.navigation.loginScreenNav
import com.nectar_demo.features.main.NavigationItem
import com.nectar_demo.features.splash.navigation.navigation.splashScreenNav

@Composable
fun NavGraph(
    navController: NavHostController,
    bottomBarState: (Boolean) -> Unit
) {

    val viewModel: MainViewModel = hiltViewModel()

    val navActions = remember(navController) {
        NavActions(navController)
    }

    NavHost(navController, startDestination = viewModel.getSplashRoute()) {
        composable(NavigationItem.Shop.route) {
            DefaultScreen(item = NavigationItem.Shop)
        }
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

        splashScreenNav(navAction = navActions) {
            bottomBarState(false)
        }
        loginScreenNav(navAction = navActions){}
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