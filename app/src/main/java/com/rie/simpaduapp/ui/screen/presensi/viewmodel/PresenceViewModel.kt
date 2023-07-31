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

    private val _uiState = MutableLiveData<UiState<DefaultResponse>>()
    val uiState: LiveData<UiState<DefaultResponse>> get() = _uiState


    private val _id = MutableLiveData<Int>()
    val id: LiveData<Int> get() = _id

    // Function to set the id
    fun setId(id: Int) {
        _id.value = id
    }

    // Function to get the id
    fun getId(): Int {
        return id.value ?: 0
    }

     suspend fun createPresensiById(id: Int, status: String) {
         Log.d("PresenceViewModel", "createPresensiById - id: $id, status: $status")
        repository.createById(id, status)
    }



    private val _nama_mk: MutableStateFlow<Result<List<PresensiResponse>>> =
        MutableStateFlow(Result.Loading)
    val nama_mk: StateFlow<Result<List<PresensiResponse>>>
        get() = _nama_mk

    private val _pertemuan: MutableStateFlow<Result<List<RiwayatPresensiResponse>>> =
        MutableStateFlow(Result.Loading)
    val pertemuan: StateFlow<Result<List<RiwayatPresensiResponse>>>
        get() = _pertemuan


    fun getRiwayatPresence() {
        viewModelScope.launch {
            repository.getRiwayatPresensi()
                .catch {
                    _pertemuan.value = Result.Error(it.message.toString())
                }
                .collect { pertemuan ->
                    _pertemuan.value = Result.Success(pertemuan)
                }
        }
    }


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