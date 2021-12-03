package com.nectar_demo.features.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nectar_demo.base.store.UserDataStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val store: UserDataStore
) : ViewModel() {


    private val _userAuthStateFlow: MutableStateFlow<SplashScreenState> = MutableStateFlow(SplashScreenState())
    val userAuthStateFlow: StateFlow<SplashScreenState> get() = _userAuthStateFlow.asStateFlow()

    init {
        viewModelScope.launch {
            delay(2000)
            checkIfAuthorized()
        }
    }

    private fun checkIfAuthorized() {
        combine(store.login, store.password) { login, password ->
            _userAuthStateFlow.value = SplashScreenState(
                isAuthorized = when {
                    login == null && password == null -> false
                    !login.isNullOrEmpty() && !password.isNullOrEmpty() -> true
                    else -> null
                }
            )
        }.launchIn(viewModelScope)
    }
}