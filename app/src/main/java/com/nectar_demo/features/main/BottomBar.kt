package com.nectar_demo.features.main

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.nectar_demo.features.splash.navigation.route.SplashScreenRoute
import com.nectar_demo.ui.theme.midnightExpress
import com.nectar_demo.ui.theme.oceanGreen
import com.nectar_demo.ui.theme.white

@ExperimentalAnimationApi
@Composable
fun bottomBar(
    navController: NavHostController,
    bottomBarState: MutableState<Boolean>
) {
    AnimatedVisibility(
        visible = bottomBarState.value,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it }),
    )
    {
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
}

fun createBottomBarItem() =
    listOf(
        NavigationItem.Shop,
        NavigationItem.Explore,
        NavigationItem.Cart,
        NavigationItem.Favourite,
        NavigationItem.Account
    )