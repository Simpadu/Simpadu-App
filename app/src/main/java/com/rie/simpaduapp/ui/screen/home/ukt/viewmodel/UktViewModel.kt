package com.rie.simpaduapp.ui.screen.home.ukt.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rie.simpaduapp.repository.Repository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import com.rie.simpaduapp.base.Result
import com.rie.simpaduapp.base.RiwayatUktResponse
import com.rie.simpaduapp.base.UktResponse
import com.rie.simpaduapp.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class UktViewModel (private val repository: Repository) :  ViewModel()  {

    private val _virtual_akun: MutableStateFlow<UiState<UktResponse>> = MutableStateFlow(
        UiState.Loading)
    val virtual_akun: StateFlow<UiState<UktResponse>>
        get() = _virtual_akun

    fun getUktAll(){
        viewModelScope.launch {
            repository.getUkt()
                .catch {
                    _virtual_akun.value = UiState.Error(it.message.toString())

                }
                .collect{virtual_akun ->
                    _virtual_akun.value = UiState.Success(virtual_akun)
                }
        }
    }


    private val _riwayatListState = MutableStateFlow<List<RiwayatUktResponse>>(emptyList())
    val riwayatListState: StateFlow<List<RiwayatUktResponse>> get() = _riwayatListState

    private val _loadingState = MutableStateFlow<Boolean>(false)
    val loadingState: StateFlow<Boolean> get() = _loadingState

    private val _errorState = MutableStateFlow<String?>(null)
    val errorState: StateFlow<String?> get() = _errorState

    fun getAllRiwayatP() {
        viewModelScope.launch {
            try {
                _loadingState.value = true
                val riwayatList = repository.getRiwayatUkt()
                _riwayatListState.value = riwayatList
            } catch (e: Exception) {
                _errorState.value = "Failed to get riwayat ukt: ${e.message}"
            } finally {
                _loadingState.value = false
            }
        }
    }
}