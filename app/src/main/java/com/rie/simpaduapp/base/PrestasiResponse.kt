package com.rie.simpaduapp.base

import com.google.gson.annotations.SerializedName
import java.time.LocalDate

data class PrestasiResponse(

    @SerializedName("nama_prestasi")
    val nama_prestasi: String,

    @SerializedName("tingkatan_lomba")
    val tingkatan_lomba: String,

    @SerializedName("jenis_peserta")
    val jenis_peserta: String,

    @SerializedName("jumlah_peserta")
    val jumlah_peserta: String,

    @SerializedName("capaian_prestasi")
    val capaian_prestasi: String,

    @SerializedName("tanggal_lomba")
    val tanggalLomba: Any? = null,

    @SerializedName("pembina")
    val pembina: Any?=null,

)
