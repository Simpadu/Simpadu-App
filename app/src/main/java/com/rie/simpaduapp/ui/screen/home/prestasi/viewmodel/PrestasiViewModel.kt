package com.rie.simpaduapp.ui.screen.home.prestasi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rie.simpaduapp.base.PrestasiResponse
import com.rie.simpaduapp.repository.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import com.rie.simpaduapp.base.Result

class PrestasiViewModel (private val repository: Repository) :  ViewModel()  {
    private val _nama_prestasi: MutableStateFlow<Result<List<PrestasiResponse>>> = MutableStateFlow(Result.Loading)
    val nama_prestasi: StateFlow<Result<List<PrestasiResponse>>>
        get() = _nama_prestasi
    fun getPrestasi() {
        viewModelScope.launch {
            repository.getPrestasi()
                .catch {
                    _nama_prestasi.value = Result.Error(it.message.toString())
                }
                .collect { prestasiList ->
                    _nama_prestasi.value = Result.Success(prestasiList)
                }
        }
    }

    fun updatePrestasi(
        id: Int, nama_prestasi: String, tingkatan_lomba: String, jenis_peserta: String, jumlah_peserta: Int,
        capaian_prestasi: String
    ) = repository.updatePrestasi(
        id, nama_prestasi, tingkatan_lomba, jenis_peserta, jumlah_peserta,
        capaian_prestasi
    )

    fun CreatePrestasi( nama_prestasi: String, tingkatan_lomba: String,jenis_peserta: String, jumlah_peserta: String,
                        capaian_prestasi: String, tanggal_lomba: String)
    =repository.createPrestasi(
        nama_prestasi,tingkatan_lomba,jenis_peserta,jumlah_peserta,capaian_prestasi,tanggal_lomba
    )

    private val _id: MutableStateFlow<Result<List<PrestasiResponse>>> =
        MutableStateFlow(Result.Loading)
    val id: StateFlow<Result<List<PrestasiResponse>>>
    get()=_id
    fun deletePrestasi(id: Int) {
        viewModelScope.launch {
            try {
                repository.deletePrestasi(id)
                getPrestasi()
            } catch (e: Exception) {
                _nama_prestasi.value = Result.Error("Failed to delete prestasi: ${e.message}")
            }
            }
        }
}

