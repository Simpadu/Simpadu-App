package com.rie.simpaduapp.base

import com.google.gson.annotations.SerializedName

class RiwayatPresensiResponse (
    @field:SerializedName("id")
    val id: Int,
    @field:SerializedName("nama_matkul")
    val nama_matkul: String,

    @field:SerializedName("status")
    val status: String,

)