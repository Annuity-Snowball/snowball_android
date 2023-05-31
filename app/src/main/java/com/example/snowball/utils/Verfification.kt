package com.example.snowball.utils

import android.content.Context
import android.util.Log
import com.example.snowball.api.membership.MembershipServerClient
import kotlinx.coroutines.flow.first

suspend fun verifyUser(context: Context){
    val tokenStore = TokenStore(context)

    val accessToken = tokenStore.getAccessToken.first()
    val refreshKey = tokenStore.getRefreshToken.first()

    try {
        val response = MembershipServerClient.authApiService.verify(
            accessToken = accessToken,
            refreshToken = refreshKey
        )
        when(response.code()){
            200 -> {
                response.headers().let {
                    val newAccessToken = it["x-new-access-token"]
                    val newRefreshKey = it["x-new-refresh-token"]
                    saveTokenSeparately(tokenStore, newAccessToken, newRefreshKey)
                }
            }
            400 -> {
                handle400Error(response)
            }
            else -> {
                Log.e("verification function", "verification failed with code: ${response.code()}")
            }
        }
    } catch (e: Exception) {
        Log.e("verification function", "verification failed with error: $e")
    }
}

suspend fun saveTokenSeparately(
    tokenStore: TokenStore,
    accessToken: String?,
    refreshToken: String?
) {
    accessToken?.let {
        tokenStore.saveAccessToken(it)
    }
    refreshToken?.let{
        tokenStore.saveRefreshToken(it)
    }
}