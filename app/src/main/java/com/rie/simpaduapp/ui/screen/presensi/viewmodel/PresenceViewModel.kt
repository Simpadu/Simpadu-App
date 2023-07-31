package com.rie.simpaduapp.ui.screen.presensi.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rie.simpaduapp.base.DefaultResponse
import com.rie.simpaduapp.base.PresensiResponse
import com.rie.simpaduapp.repository.Repository
import kotlinx.coroutines.launch
import org.json.JSONObject
import com.rie.simpaduapp.base.Result
import com.rie.simpaduapp.base.RiwayatPresensiResponse
import com.rie.simpaduapp.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

class PresenceViewModel(private val repository: Repository) :  ViewModel()  {

     suspend fun createPresensiById(id: Int, status: String) {
         Log.d("PresenceViewModel", "createPresensiById - id: $id, status: $status")
        repository.createById(id, status)
    }



    private val _status: MutableStateFlow<Result<List<RiwayatPresensiResponse>>> =
        MutableStateFlow(Result.Loading)
    val status: StateFlow<Result<List<RiwayatPresensiResponse>>>
        get() = _status

    fun getRiwayatPresence() {
        viewModelScope.launch {
            repository.getRiwayatPresensi()
                .catch {
                    _status.value = Result.Error(it.message.toString())
                }
                .collect { pertemuan ->
                    _status.value = Result.Success(pertemuan)
                }
        }
    }



    private val _nama_mk: MutableStateFlow<Result<List<PresensiResponse>>> =
        MutableStateFlow(Result.Loading)
    val nama_mk: StateFlow<Result<List<PresensiResponse>>>
        get() = _nama_mk
    fun getAllPresence() {
        viewModelScope.launch {
            repository.getPresensi()
                .catch {
                    _nama_mk.value = Result.Error(it.message.toString())
                }
                .collect { nama_mk ->
                    _nama_mk.value = Result.Success(nama_mk)
                }
        }
    }



}