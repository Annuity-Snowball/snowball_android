package com.example.snowball.utils

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TokenStore(
    private val context: Context,
) {
    companion object {
        private val Context.datastore: DataStore<Preferences> by preferencesDataStore("token")
        val ACCESS_TOKEN_KEY = stringPreferencesKey("access_token")
        val REFRESH_TOKEN_KEY = stringPreferencesKey("refresh_token")
    }


    val getAccessToken: Flow<String> = context.datastore.data
        .map { preference ->
            preference[ACCESS_TOKEN_KEY] ?: ""
        }

    suspend fun saveAccessToken(access_token: String){
        context.datastore.edit { preference ->
            preference[ACCESS_TOKEN_KEY] = access_token
            Log.i("LOGIN", "saved access_token : $access_token")
        }
    }

    val getRefreshToken: Flow<String> = context.datastore.data
        .map { preference ->
            preference[REFRESH_TOKEN_KEY] ?: ""
        }

    suspend fun saveRefreshToken(refresh_token: String){
        context.datastore.edit { preference ->
            preference[REFRESH_TOKEN_KEY] = refresh_token
            Log.i("LOGIN", "saved refresh_token : $refresh_token")
        }
    }
}