package com.rie.simpaduapp.base

import com.google.gson.annotations.SerializedName

data class HomeResponse(
    @field:SerializedName("minggu")
    val minggu: String,

    @field:SerializedName("status_mahasiswa")
    val status_mahasiswa: String,

    @field:SerializedName("total_sks")
    val total_sks:String,

    @field:SerializedName("ipk")
    val ipk:String,

    )