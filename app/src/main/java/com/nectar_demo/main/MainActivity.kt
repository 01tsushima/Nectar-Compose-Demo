package com.nectar_demo.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ProvideWindowInsets
import com.nectar_demo.features.main.bottomBar
import com.nectar_demo.ui.theme.NectarDemoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { activityContent() }
    }

    @ExperimentalAnimationApi
    @Composable
    fun activityContent() {
        navController = rememberNavController()
        val bottomBarState = rememberSaveable { (mutableStateOf(false)) }
        ProvideWindowInsets{
            NectarDemoTheme {
                Scaffold(
                    bottomBar = { bottomBar(navController = navController, bottomBarState = bottomBarState) },
                ) {
                    NavGraph(navController = navController,bottomBarState  = {bottomBarState.value = it })
                }
            }
        }
    }
}

