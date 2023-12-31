package com.rie.simpaduapp.service

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class AuthInterceptor(private var token: String, private var context: Context): Interceptor {
    companion object {
        const val AUTHORIZATION = "Authorization"
    }
    override fun intercept(chain: Interceptor.Chain): Response {
        var request: Request = chain.request()

        request = if (request.header("No-Authentication") == null && token.isNotEmpty()) {
            val accessToken = token

            request.newBuilder()
                .removeHeader(AUTHORIZATION)
                .addHeader(AUTHORIZATION, accessToken)
                .build()
        } else {
            request.newBuilder()
                .build()
        }
        val response = chain.proceed(request)
        if (response.code == 403) {
            val sharedPreferences =
                context.getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
            val newToken = sharedPreferences.getString("token", null).toString()

            request = request.newBuilder()
                .removeHeader(AUTHORIZATION)
                .addHeader(AUTHORIZATION, newToken)
                .build()

            return chain.proceed(request)
        }
        return response
        }
}