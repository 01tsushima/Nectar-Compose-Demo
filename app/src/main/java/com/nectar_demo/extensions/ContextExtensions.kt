package com.nectar_demo.extensions

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.nectar_demo.common.Constants

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
    name = Constants.preferences
)