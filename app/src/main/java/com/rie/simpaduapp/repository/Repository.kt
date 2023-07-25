package com.rie.simpaduapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.rie.simpaduapp.base.AuthResponse
import com.rie.simpaduapp.service.ApiService
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject

class Repository(private val apiService: ApiService) {

    fun login(nim: String, password: String): LiveData<Result<AuthResponse>> = liveData {
        val json = JSONObject()
        json.put("nim", nim)
        json.put("password", password)
        val requestBody = json.toString().toRequestBody("application/json".toMediaTypeOrNull())
        emit(Result.Loading)
        try {
            val response = apiService.login(requestBody)
            emit(Result.Success(response))
        } catch (e: Exception) {
            Log.e(TAG, "Login: ${e.message.toString()}")
            emit(Result.Error(e.message.toString()))
            }
        }

    companion object {
        private const val TAG = "Repository"
    }

}