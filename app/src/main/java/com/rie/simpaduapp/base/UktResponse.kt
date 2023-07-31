package com.rie.simpaduapp.base

import com.google.gson.annotations.SerializedName

data class UktResponse(
    @SerializedName("nim")
    val nim: String,

    @SerializedName("nama")
    val nama: String,

    @SerializedName("prodi")
    val prodi: String,

    @SerializedName("virtual_akun")
    val virtual_akun: String,

    @SerializedName("status_bebas_masalah")
    val status_bebas_masalah: String,

    @SerializedName("status_spp_semester_sebelumnya")
    val statusSppSemesterSebelumnya: String,

    @SerializedName("kode_pembayaran")
    val kode_pembayaran: String,

    @SerializedName("catatan")
    val catatan:String
)