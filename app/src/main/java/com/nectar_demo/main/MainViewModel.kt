package com.nectar_demo.main

import androidx.lifecycle.ViewModel
import com.nectar_demo.base.store.UserDataStore
import com.nectar_demo.features.splash.navigation.route.SplashScreenRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val store: UserDataStore
) : ViewModel() {
    fun getSplashRoute(): String {
        return SplashScreenRoute.route
    }
}