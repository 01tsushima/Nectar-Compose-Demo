package com.nectar_demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.nectar_demo.acitivity.bottom.bar.ActivityMainNavigationConfigurations
import com.nectar_demo.acitivity.bottom.bar.bottomBar
import com.nectar_demo.ui.theme.NectarDemoTheme
import com.nectar_demo.ui.theme.background
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navController = rememberNavController()
            NectarDemoTheme {
                this@MainActivity.window.statusBarColor = MaterialTheme.colors.primary.toArgb()
                Scaffold(
                    bottomBar = { bottomBar(navController = navController) },
                    backgroundColor = background
                ) {
                    ActivityMainNavigationConfigurations(navController = navController)
                }
            }
        }
    }
}

