package com.rie.simpaduapp.base

import com.google.gson.annotations.SerializedName
import java.time.LocalDate

data class RiwayatUktResponse(
    @field:SerializedName("status")
    val status: String,
//
//    @field:SerializedName("tanggal_registrasi")
//    val tanggal_registrasi: LocalDate,
//
//    @field:SerializedName("tahun_akademik")
//    val tahun_akademik:Char,

    @field:SerializedName("tanggal_registrasi")
    val tanggal_registrasi: String,

    @field:SerializedName("tahun_akademik")
    val tahun_akademik: String

    )