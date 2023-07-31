package com.rie.simpaduapp.ui.screen.home.magang.viewmodel

import androidx.lifecycle.ViewModel
import com.rie.simpaduapp.repository.Repository

class InternViewModel(private val repository: Repository) :  ViewModel()  {

    fun updateMagang(nama:String, judul:String, tempat_magang:String)
    =repository.updateMagang(nama,judul,tempat_magang)
}