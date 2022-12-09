package com.example.snowball.viewModels.service

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