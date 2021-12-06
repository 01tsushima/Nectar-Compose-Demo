package com.nectar_demo.features.login

import com.nectar_demo.features.login.navigation.LoginEvent

data class LoginScreenState(
    val login: String = "",
    val password: String = "",
    val isAuth:LoginEvent? = null,
    val isPasswordVisible:Boolean = false
)