package com.rie.simpaduapp.data

import android.content.Context
import com.rie.simpaduapp.repository.Repository
import com.rie.simpaduapp.service.ApiConfig

object Injection {
    fun provideRepository(context: Context): Repository {
        val apiService = ApiConfig.getApiService(context)
        return Repository(apiService)
    }
}
