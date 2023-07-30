package com.rie.simpaduapp.base

import com.google.gson.annotations.SerializedName

data class PengumumanResponse(
    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("judul")
    val judul: String,

    @field:SerializedName("url")
    val url:String,

    )