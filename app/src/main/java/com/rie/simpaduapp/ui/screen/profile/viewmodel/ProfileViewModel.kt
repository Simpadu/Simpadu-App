package com.rie.simpaduapp.ui.screen.profile.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rie.simpaduapp.base.DefaultResponse
import com.rie.simpaduapp.base.MahasiswaResponse
import com.rie.simpaduapp.repository.Repository
import com.rie.simpaduapp.ui.common.UiState
import kotlinx.coroutines.launch
import java.io.InputStream
import java.util.*
import com.rie.simpaduapp.base.Result
import kotlinx.coroutines.flow.*

class ProfileViewModel(private val repository: Repository) :  ViewModel()  {
    private val _logout: MutableStateFlow<UiState<DefaultResponse>> = MutableStateFlow(
        UiState.Loading
    )
    val logout: StateFlow<UiState<DefaultResponse>>
        get() = _logout

    private val _foto_profile: MutableStateFlow<Result<DefaultResponse>> = MutableStateFlow(
        Result.Loading
    )
    val photo: StateFlow<Result<DefaultResponse>>
        get() =_foto_profile

    fun logout() = repository.logout()


    private val _nama: MutableStateFlow<UiState<MahasiswaResponse>> = MutableStateFlow(UiState.Loading)
    private val _email: MutableStateFlow<UiState<MahasiswaResponse>> = MutableStateFlow(UiState.Loading)
    val nama: StateFlow<UiState<MahasiswaResponse>>
        get() = _nama
    val email: StateFlow<UiState<MahasiswaResponse>>
        get() = _email
  fun getProfile(){
      viewModelScope.launch {
          repository.getProfile()
              .catch {
                  _nama.value = UiState.Error(it.message.toString())
                  _email.value = UiState.Error(it.message.toString())
              }
              .collect{nama ->
                  _nama.value = UiState.Success(nama)
              }
//              .collect{email ->
//                  _email.value = UiState.Success(email)
//              }
      }
  }

    fun changePhoto(uri: InputStream) {
        viewModelScope.launch {
            _foto_profile.update {
                repository.changePhoto(uri)
            }
        }
    }

    fun updateProfile(nama: String,tempat_lahir: String,  no_hp: String, email: String, alamat: String,
                      nama_ibu: String, nama_ayah:String, kecamatan:String, kelurahan:String)
    =repository.updateProfile(nama,tempat_lahir, no_hp, email,alamat,nama_ibu,nama_ayah,kecamatan,kelurahan)


}