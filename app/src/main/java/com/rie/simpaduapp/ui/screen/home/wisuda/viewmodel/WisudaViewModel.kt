package com.rie.simpaduapp.ui.screen.home.wisuda.viewmodel

import androidx.lifecycle.ViewModel
import com.rie.simpaduapp.repository.Repository

class WisudaViewModel(private val repository: Repository) :  ViewModel()  {
    fun updateWisuda(
        pengalaman_organisasi: String, pengalaman_pelatihan: String, pengalaman_prestasi: String,
        nama_ayah: String, alamat_ortu: String,judul_tugas_akhir:String
    ) = repository.updateWisuda(
        pengalaman_organisasi, pengalaman_pelatihan, pengalaman_prestasi,
        nama_ayah, alamat_ortu, judul_tugas_akhir
        )

}