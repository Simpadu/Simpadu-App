package com.rie.simpaduapp.base

import com.google.gson.annotations.SerializedName
import java.time.LocalDate

data class RiwayatUktResponse(
    @field:SerializedName("status")
    val status: String,

    @field:SerializedName("tanggal_registrasi")
    val tglRegistrasi: LocalDate,

    @field:SerializedName("tahun_akademik")
    val tahunAkademik:Char,

    )