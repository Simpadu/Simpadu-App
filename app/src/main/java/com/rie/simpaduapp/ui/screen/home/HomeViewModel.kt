package com.rie.simpaduapp.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rie.simpaduapp.base.HomeResponse
import com.rie.simpaduapp.base.MahasiswaResponse
import com.rie.simpaduapp.repository.Repository
import com.rie.simpaduapp.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel (private val repository: Repository) : ViewModel()  {
    private val _minggu: MutableStateFlow<com.rie.simpaduapp.ui.common.UiState<HomeResponse>> = MutableStateFlow(
        com.rie.simpaduapp.ui.common.UiState.Loading)
    val minggu: StateFlow<com.rie.simpaduapp.ui.common.UiState<HomeResponse>>
        get() = _minggu

    private val _status_mahasiswa: MutableStateFlow<com.rie.simpaduapp.ui.common.UiState<HomeResponse>> = MutableStateFlow(
        com.rie.simpaduapp.ui.common.UiState.Loading)
    val status_mahasiswa: StateFlow<com.rie.simpaduapp.ui.common.UiState<HomeResponse>>
        get() = _status_mahasiswa

    private val _total_sks: MutableStateFlow<com.rie.simpaduapp.ui.common.UiState<HomeResponse>> = MutableStateFlow(
        com.rie.simpaduapp.ui.common.UiState.Loading)
    val total_sks: StateFlow<com.rie.simpaduapp.ui.common.UiState<HomeResponse>>
        get() = _total_sks

    private val _ipk: MutableStateFlow<com.rie.simpaduapp.ui.common.UiState<HomeResponse>> = MutableStateFlow(
        com.rie.simpaduapp.ui.common.UiState.Loading)
    val ipk: StateFlow<com.rie.simpaduapp.ui.common.UiState<HomeResponse>>
        get() = _ipk

    private val _nama: MutableStateFlow<com.rie.simpaduapp.ui.common.UiState<MahasiswaResponse>> = MutableStateFlow(
        com.rie.simpaduapp.ui.common.UiState.Loading)
    val nama: StateFlow<com.rie.simpaduapp.ui.common.UiState<MahasiswaResponse>>
        get() = _nama

    fun getNama(){
        viewModelScope.launch {
            repository.getProfile()
                .catch {
                    _nama.value = com.rie.simpaduapp.ui.common.UiState.Error(it.message.toString())

                }
                .collect{ nama ->
                    _nama.value = com.rie.simpaduapp.ui.common.UiState.Success(nama)
                }
        }
    }

  fun getHome(){
      viewModelScope.launch {
          repository.getHome()
              .catch {
                  _minggu.value = com.rie.simpaduapp.ui.common.UiState.Error(it.message.toString())

              }
              .collect{minggu ->
                  _minggu.value = com.rie.simpaduapp.ui.common.UiState.Success(minggu)
              }
      }
  }
    fun getStatus(){
        viewModelScope.launch {
            repository.getHome()
                .catch {
                    _status_mahasiswa.value = com.rie.simpaduapp.ui.common.UiState.Error(it.message.toString())
                }
                .collect{status_mahasiswa ->
                    _status_mahasiswa.value = com.rie.simpaduapp.ui.common.UiState.Success(status_mahasiswa)
                }
        }
    }

    fun getSks(){
        viewModelScope.launch {
            repository.getHome()
                .catch {
                    _total_sks.value = com.rie.simpaduapp.ui.common.UiState.Error(it.message.toString())
                }
                .collect{total_sks ->
                    _total_sks.value = com.rie.simpaduapp.ui.common.UiState.Success(total_sks)
                }
        }
    }

    fun getIpk(){
        viewModelScope.launch {
            repository.getHome()
                .catch {
                    _ipk.value = com.rie.simpaduapp.ui.common.UiState.Error(it.message.toString())
                }
                .collect{ipk ->
                    _ipk.value = com.rie.simpaduapp.ui.common.UiState.Success(ipk)
                }
        }
    }

}