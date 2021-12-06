package com.nectar_demo.features.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nectar_demo.base.store.UserDataStore
import com.nectar_demo.features.login.navigation.LoginEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val store: UserDataStore
) : ViewModel() {

    private val _userAuthStateFlow: MutableStateFlow<LoginScreenState> = MutableStateFlow(LoginScreenState())
    val userAuthStateFlow: StateFlow<LoginScreenState> get() = _userAuthStateFlow.asStateFlow()

    fun updateLogin(value: String) {
        viewModelScope.launch {
            _userAuthStateFlow.value = _userAuthStateFlow.value.copy(login = value)
        }
    }

    fun updatePassword(value: String) {
        viewModelScope.launch {
            _userAuthStateFlow.value = _userAuthStateFlow.value.copy(password = value)
        }
    }

    fun doLogin() {
        viewModelScope.launch {
            store.saveUserCredentials(_userAuthStateFlow.value.login, _userAuthStateFlow.value.login)
            _userAuthStateFlow.value = _userAuthStateFlow.value.copy(isAuth = LoginEvent)
        }
    }

    fun togglePassword() {
        viewModelScope.launch {
            _userAuthStateFlow.value = _userAuthStateFlow.value.copy(
                isPasswordVisible = !_userAuthStateFlow.value.isPasswordVisible
            )
        }
    }
}