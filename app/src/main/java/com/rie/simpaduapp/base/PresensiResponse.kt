package com.rie.simpaduapp.base

import com.google.gson.annotations.SerializedName

data class PresensiResponse(
    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("nama_matkul")
    val namaMatkul: String,

    @field:SerializedName("status")
    val status:String,

    )