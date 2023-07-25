package com.rie.simpaduapp.base

import com.google.gson.annotations.SerializedName

data class HomeResponse(
    @SerializedName("minggu")
    val minggu: Int,

    @SerializedName("status_mahasiswa")
    val statusMahasiswa: String,

    @SerializedName("total_sks")
    val totalSks: Int,

    @SerializedName("ipk")
    val ipk:Double,
)