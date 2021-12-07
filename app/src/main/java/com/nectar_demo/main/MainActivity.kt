package com.nectar_demo.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.paging.ExperimentalPagingApi
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.pager.ExperimentalPagerApi
import com.nectar_demo.features.main.bottomBar
import com.nectar_demo.ui.theme.NectarDemoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    @ExperimentalPagingApi
    @ExperimentalPagerApi
    @ExperimentalComposeUiApi
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { activityContent() }
    }

    @ExperimentalComposeUiApi
    @ExperimentalPagerApi
    @ExperimentalPagingApi
    @ExperimentalAnimationApi
    @Composable
    fun activityContent() {
        navController = rememberNavController()
        ProvideWindowInsets {
            NectarDemoTheme {
                Scaffold(
                    bottomBar = { bottomBar(navController = navController) },
                ) {
                    NavGraph(navController = navController)
                }
            }
        }
    }
}

