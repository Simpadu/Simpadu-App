package com.rie.simpaduapp.base

import com.google.gson.annotations.SerializedName

data class PengumumanResponse(
    @field:SerializedName("judul")
    val judul: String,

    @field:SerializedName("isi")
    val isi: String,

    @field:SerializedName("url")
    val Url:String,

    )