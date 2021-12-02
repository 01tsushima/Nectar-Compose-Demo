package com.nectar_demo.acitivity.bottom.bar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun ActivityMainNavigationConfigurations(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Shop.route) {
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