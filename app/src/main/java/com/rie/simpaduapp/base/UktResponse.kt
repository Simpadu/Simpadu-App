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
    val virtualAkun: String,

    @SerializedName("status_bebas_masalah")
    val statusBebasMasalah: String,

    @SerializedName("status_spp_semester_sebelumnya")
    val statusSppSemesterSebelumnya: String,

    @SerializedName("kode_pembayaran")
    val kodePembayaran: String,

    @SerializedName("catatan")
    val catatan:String
)