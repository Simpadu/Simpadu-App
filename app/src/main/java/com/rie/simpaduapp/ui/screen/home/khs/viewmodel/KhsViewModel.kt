package com.rie.simpaduapp.ui.screen.home.khs.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rie.simpaduapp.base.RiwayatKhsResponse
import com.rie.simpaduapp.repository.Repository
import com.rie.simpaduapp.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class KhsViewModel(private val repository: Repository) :  ViewModel()  {
    private val _semester: MutableStateFlow<UiState<RiwayatKhsResponse>> = MutableStateFlow(
        UiState.Loading)
    val semester: StateFlow<UiState<RiwayatKhsResponse>>
        get() = _semester

//    fun geRiwayatKhsAll(){
//        viewModelScope.launch {
//            repository.getRiwayaKonsultasiKhs()
//                .catch {
//                    _semester.value = UiState.Error(it.message.toString())
//
//                }
//                .collect{semester ->
//                    _semester.value = UiState.Success(semester)
//                }
//        }
//    }

    fun CreateKonsultasi(keterangan : String) =repository.createKonsultasiKhs(keterangan)




}