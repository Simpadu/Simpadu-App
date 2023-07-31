package com.rie.simpaduapp.base

import com.google.gson.annotations.SerializedName

class RiwayatPresensiResponse (
    @field:SerializedName("pertemuan")
    val pertemuan: Int,
    @field:SerializedName("nama_matkul")
    val nama_matkul: String,

    @field:SerializedName("status")
    val status: String,

)