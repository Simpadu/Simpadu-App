package com.rie.simpaduapp.ui.screen.profile.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rie.simpaduapp.base.DefaultResponse
import com.rie.simpaduapp.repository.Repository
import com.rie.simpaduapp.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.io.InputStream
import java.util.*

class ProfileViewModel(private val repository: Repository) :  ViewModel()  {
    private val _logout: MutableStateFlow<UiState<DefaultResponse>> = MutableStateFlow(
        UiState.Loading
    )
    val logout: StateFlow<UiState<DefaultResponse>>
        get() = _logout

    private val _photo: MutableStateFlow<UiState<DefaultResponse>> = MutableStateFlow(
        UiState.Loading
    )
    val photo: StateFlow<UiState<DefaultResponse>>
        get() = _photo

    fun logout() = repository.logout()


//    fun changePhoto(uri: InputStream) {
//        viewModelScope.launch {
//            _photo.update {
//                repository.changePhoto(uri)
//            }
//        }
//    }

    fun updateProfile(nama: String,tempat_lahir: String,  no_hp: String, email: String, alamat: String,
                      nama_ibu: String, nama_ayah:String, kecamatan:String, kelurahan:String)
    =repository.updateProfile(nama,tempat_lahir, no_hp, email,alamat,nama_ibu,nama_ayah,kecamatan,kelurahan)


}