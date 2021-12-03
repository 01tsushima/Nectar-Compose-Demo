package com.nectar_demo.common

import androidx.datastore.preferences.core.stringPreferencesKey

object PreferencesKey {
    private const val Login = "Login"
    val FIELD_LOGIN = stringPreferencesKey(Login)

    private const val Password = "Password"
    val Field_PASSWORD = stringPreferencesKey(Password)
}