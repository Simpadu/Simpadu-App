package com.rie.simpaduapp.base.ui.screen.presensi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rie.simpaduapp.base.DefaultResponse
import com.rie.simpaduapp.base.PresensiResponse
import com.rie.simpaduapp.repository.Repository
import com.rie.simpaduapp.base.ui.common.UiState
import kotlinx.coroutines.launch
import org.json.JSONObject
import com.rie.simpaduapp.base.Result

class PresenceViewModel(private val repository: Repository) :  ViewModel()  {
    private val _presensidibuka = MutableLiveData<com.rie.simpaduapp.base.ui.common.UiState<List<PresensiResponse>>>()
    val presensidibuka: LiveData<com.rie.simpaduapp.base.ui.common.UiState<List<PresensiResponse>>> get() = _presensidibuka

    private val _uiState = MutableLiveData<com.rie.simpaduapp.base.ui.common.UiState<DefaultResponse>>()
    val uiState: LiveData<com.rie.simpaduapp.base.ui.common.UiState<DefaultResponse>> get() = _uiState

    fun createPresensiById(id: Int, status: String) {
        _uiState.postValue(com.rie.simpaduapp.base.ui.common.UiState.Loading)
        val json = JSONObject()
        json.put("status", status)
        val jsonString = json.toString()
        viewModelScope.launch {
            try {
                repository.createPresensiById(id, jsonString).collect { result ->
                    when (result) {
                        is Result.Success -> _uiState.postValue(com.rie.simpaduapp.base.ui.common.UiState.Success(result.data))
                        is Result.Error -> _uiState.postValue(com.rie.simpaduapp.base.ui.common.UiState.Error(result.error))
                        Result.Loading -> _uiState.postValue(com.rie.simpaduapp.base.ui.common.UiState.Loading)
                    }
                }
            } catch (e: Exception) {
                _uiState.postValue(com.rie.simpaduapp.base.ui.common.UiState.Error(e.message.toString()))
            }
        }
    }

    fun getPresensi() {
        _presensidibuka.postValue(com.rie.simpaduapp.base.ui.common.UiState.Loading)
        viewModelScope.launch {
            try {
                repository.getPresensi().collect { response ->
                    _presensidibuka.postValue(com.rie.simpaduapp.base.ui.common.UiState.Success(response))
                }
            } catch (e: Exception) {
                _presensidibuka.postValue(com.rie.simpaduapp.base.ui.common.UiState.Error(e.message.toString()))
            }
            }
        }

}