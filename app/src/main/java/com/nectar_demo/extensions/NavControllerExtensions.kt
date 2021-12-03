package com.nectar_demo.extensions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.navigation.NavController

@Composable
fun NavController.AddChangeRouteListener() {

    DisposableEffect(this) {
        val callback = NavController.OnDestinationChangedListener { controller, _, _ ->
            controller.currentDestination?.route?.let { route ->

            }
        }
        addOnDestinationChangedListener(callback)
        // remove the navController on dispose (i.e. when the composable is destroyed)
        onDispose {
            removeOnDestinationChangedListener(callback)
        }
    }
}