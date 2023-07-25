package com.rie.simpaduapp.service

import android.content.Context
import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiConfig {
    companion object {
        private fun getInterceptor(token: String?, context: Context): OkHttpClient {
            val loggingInterceptor =
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            return if (token.isNullOrEmpty()) {
                OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .build()
            } else {
                OkHttpClient.Builder()
                    .addInterceptor(AuthInterceptor(token, context))
                    .addInterceptor(loggingInterceptor)
                    .build()
            }
        }

        fun getApiService(context: Context): ApiService {
            val sharedPreferences =
                context.getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
            val token = sharedPreferences.getString("access_token", null).toString()
            Log.d("ApiConfig", token)

            val retrofit = Retrofit.Builder()
                .baseUrl("http://13.212.11.54:4000")
                .addConverterFactory(GsonConverterFactory.create())
                .client(getInterceptor(token, context))
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}