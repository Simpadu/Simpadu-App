package com.rie.simpaduapp.ui.screen.profile.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
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
    private val _logout: MutableStateFlow<com.rie.simpaduapp.ui.common.UiState<DefaultResponse>> = MutableStateFlow(
        com.rie.simpaduapp.ui.common.UiState.Loading
    )
    val logout: StateFlow<com.rie.simpaduapp.ui.common.UiState<DefaultResponse>>
        get() = _logout

    private val _foto_profil: MutableStateFlow<Result<DefaultResponse>> = MutableStateFlow(
        Result.Loading
    )
    val foto_profil: StateFlow<Result<DefaultResponse>>
        get() =_foto_profil

    fun logout() = repository.logout()

//
//    private val _nama: MutableStateFlow<UiState<MahasiswaResponse>> = MutableStateFlow(UiState.Loading)
//    private val _email: MutableStateFlow<UiState<MahasiswaResponse>> = MutableStateFlow(UiState.Loading)
//    val nama: StateFlow<UiState<MahasiswaResponse>>
//        get() = _nama
//    val email: StateFlow<UiState<MahasiswaResponse>>
//        get() = _email
//  fun getProfile(){
//      viewModelScope.launch {
//          repository.getProfile()
//              .catch {
//                  _nama.value = UiState.Error(it.message.toString())
//              }
//              .collect{nama ->
//                  _nama.value = UiState.Success(nama)
//              }
//      }
//  }

    private val _nama = mutableStateOf("Mahasiswa Guest")
    val nama: State<String> get() = _nama

    private val _email = mutableStateOf("user@mahasiswa.poliban.ac.id")
    val email: State<String> get() = _email

    private val _imageUser = mutableStateOf("https://www.citypng.com/public/uploads/preview/free-round-flat-male-portrait-avatar-user-icon-png-11639648873oplfof4loj.png")
    val imageUser: State<String> get() = _imageUser
    fun getProfile() {
        viewModelScope.launch {
            // Misalnya
              repository.getProfile().collect { data ->
                 _nama.value = data.nama.toString()
                 _email.value = data.email.toString()
                 _imageUser.value = data.foto_profil ?: _imageUser.value
             }
            // Pastikan menghandle error jika terjadi kegagalan pengambilan data
        }
    }

    fun changePhoto(uri: InputStream) {
        viewModelScope.launch {
            _foto_profil.update {
                repository.changePhoto(uri)
            }
        }
    }

    fun updateProfile(nama: String,tempat_lahir: String,  no_hp: String, email: String, alamat: String,
                      nama_ibu: String, nama_ayah:String, kecamatan:String, kelurahan:String)
    =repository.updateProfile(nama,tempat_lahir, no_hp, email,alamat,nama_ibu,nama_ayah,kecamatan,kelurahan)

   fun createResetEmail(keterangan :String) =repository.createResetEmail(keterangan)
}