package com.rie.simpaduapp.ui.screen.notification.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rie.simpaduapp.base.PengumumanResponse
import com.rie.simpaduapp.repository.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import com.rie.simpaduapp.base.Result

class NotificationViewModel(private val repository: Repository) :  ViewModel()  {
    private val _judul: MutableStateFlow<Result<List<PengumumanResponse>>> = MutableStateFlow(Result.Loading)
    val judul: StateFlow<Result<List<PengumumanResponse>>>
        get() = _judul

    fun getAllPengumuman() {
        viewModelScope.launch {
            repository.getAllPengumuman()
                .catch {
                    _judul.value = Result.Error(it.message.toString())
                }
                .collect { pengumumanList ->
                    _judul.value = Result.Success(pengumumanList)
                }
        }
    }

}