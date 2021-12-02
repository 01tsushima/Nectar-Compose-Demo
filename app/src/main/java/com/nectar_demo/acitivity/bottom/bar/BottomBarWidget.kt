package com.nectar_demo.acitivity.bottom.bar

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.nectar_demo.ui.theme.midnightExpress
import com.nectar_demo.ui.theme.oceanGreen
import com.nectar_demo.ui.theme.white

@Composable
fun bottomBar(
    navController: NavHostController
) {
    BottomNavigation(backgroundColor = white) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route ?: NavigationItem.Shop.route
        createBottomBarItem().forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = null,
                        tint = if (item.route == currentRoute) oceanGreen else midnightExpress
                    )
                },
                selected = currentRoute == item.route,
                alwaysShowLabel = true,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route)
                    }
                },
                selectedContentColor = oceanGreen,
                unselectedContentColor = midnightExpress
            )
        }
    }
}

fun createBottomBarItem() =
    listOf(
        NavigationItem.Shop,
        NavigationItem.Explore,
        NavigationItem.Cart,
        NavigationItem.Favourite,
        NavigationItem.Account
    )