package com.rie.simpaduapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.google.gson.Gson
import com.rie.simpaduapp.base.AuthResponse
import com.rie.simpaduapp.base.DefaultResponse
import com.rie.simpaduapp.base.MahasiswaResponse
import com.rie.simpaduapp.model.profile.FaqModel
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

    fun logout(): LiveData<Result<DefaultResponse>> = liveData {
        try {
            val response = apiService.logout()
            Log.d(TAG, response.toString())
            emit(Result.Success(response))
        } catch (e: Exception) {
            Log.e(TAG, "logoutRepository: ${e.message.toString()}")
        }
    }

    fun updateProfile(mahasiswa: MahasiswaResponse): LiveData<Result<DefaultResponse>> = liveData {
        val requestBody = createRequestBody(mahasiswa)
        emit(Result.Loading)
        try {
            val response = apiService.updateProfile(requestBody)
            emit(Result.Success(response))
        } catch (e: Exception) {
            emit(Result.Error(e.message ?: "Terjadi kesalahan"))
        } }

    private fun createRequestBody(mahasiswa: MahasiswaResponse): okhttp3.RequestBody {
        val json = JSONObject()
        json.put("nim", mahasiswa.nim)
        json.put("nama", mahasiswa.nama)
        json.put("nik", mahasiswa.nik.toString())
        json.put("tanggal_lahir", mahasiswa.tanggal_lahir?.toString())
        json.put("tempat_lahir", mahasiswa.tempat_lahir)
        json.put("no_hp", mahasiswa.no_hp)
        json.put("email", mahasiswa.email)
        json.put("alamat", mahasiswa.alamat)
        json.put("semester", mahasiswa.semester.toString())
        json.put("nama_ibu", mahasiswa.nama_ibu)
        json.put("nama_ayah", mahasiswa.nama_ayah)
        json.put("kode_pos", mahasiswa.kode_pos.toString())
        json.put("kecamatan", mahasiswa.kecamatan)
        json.put("kelurahan", mahasiswa.kelurahan)
        json.put("virtual_account", mahasiswa.virtual_account)
        json.put("status_mahasiswa", mahasiswa.status_mahasiswa)
        json.put("kelas_id", mahasiswa.kelas_id.toString())
        json.put("agama_id", mahasiswa.agama_id.toString())
        json.put("dosen_wali", mahasiswa.dosen_wali.toString())
        json.put("status", mahasiswa.status)
        return json.toString().toRequestBody("application/json".toMediaTypeOrNull())
        }


    companion object {
        private const val TAG = "Repository"
    }

}