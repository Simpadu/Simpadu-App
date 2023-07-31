package com.rie.simpaduapp.base

import com.google.gson.annotations.SerializedName

data class PresensiResponse(
    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("nama_mk")
    val nama_mk: String,

    @field:SerializedName("status")
    val status: String,

    @field:SerializedName("masih_dibuka")
    val masih_dibuka: Boolean // Ubah tipe data menjadi Boolean
)
