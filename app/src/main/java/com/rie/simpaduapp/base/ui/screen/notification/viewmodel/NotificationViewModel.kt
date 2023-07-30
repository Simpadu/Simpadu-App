package com.rie.simpaduapp.base.ui.screen.notification.viewmodel

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
    private val _getPengumumanById: MutableStateFlow<Result<PengumumanResponse>> =
        MutableStateFlow(Result.Loading)
    val getPengumumanById: StateFlow<Result<PengumumanResponse>>
        get() = _getPengumumanById

    private val _pengumuman: MutableStateFlow<Result<List<PengumumanResponse>>> = MutableStateFlow(Result.Loading)
    val outcome: StateFlow<Result<List<PengumumanResponse>>>
        get() = _pengumuman


    fun getPengumuman() {
        viewModelScope.launch {
            repository.getPengumuman()
                .catch {
                    _pengumuman.value = Result.Error(it.message.toString())
                }
                .collect { pengumuman ->
                    _pengumuman.value = Result.Success(pengumuman)
                }
        }
    }

    fun getPengumumanById(id: Int) {
        viewModelScope.launch {
            repository.getPengumumanById(id)
                .catch {
                    Log.d("tes", it.message.toString())
                    _getPengumumanById.value = Result.Error(it.message.toString())
                }
                .collect { pengumuman ->
                    _getPengumumanById.value = Result.Success(pengumuman)
                }
            }
        }
}