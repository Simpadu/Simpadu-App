package com.rie.simpaduapp.base

import com.google.gson.annotations.SerializedName

data class KrsResponse(
    @field:SerializedName("nama_mk")
    val namaMK: String,

    @field:SerializedName("sks")
    val sks: Int,

    @field:SerializedName("jam")
    val jam:Int,

)