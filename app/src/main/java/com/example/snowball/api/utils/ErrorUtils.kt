package com.example.snowball.api.utils

import com.example.snowball.api.RetrofitService
import okhttp3.ResponseBody

class ErrorUtils {
    companion object {
        inline fun <reified T> getErrorResponse(errorBody: ResponseBody): T? {
            return RetrofitService.retrofit.responseBodyConverter<T>(
                T::class.java,
                T::class.java.annotations
            ).convert(errorBody)
        }
    }
}