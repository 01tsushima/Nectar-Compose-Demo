package com.nectar_demo.base.store

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.nectar_demo.common.PreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserDataStore @Inject constructor(private val dataStore: DataStore<Preferences>) {

    val login: Flow<String?> = dataStore.data.map {
        it[PreferencesKey.FIELD_LOGIN]
    }

    val password: Flow<String?> = dataStore.data.map {
        it[PreferencesKey.Field_PASSWORD]
    }

    suspend fun saveUserCredentials(login: String, password: String) {
        dataStore.edit {
            it[PreferencesKey.FIELD_LOGIN] = login
            it[PreferencesKey.Field_PASSWORD] = password
        }
    }
}