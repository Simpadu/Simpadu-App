package com.rie.simpaduapp.base

import com.google.gson.annotations.SerializedName

data class RiwayatKhsResponse (
    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("keterangan")
    val keterangan: String,

    @field:SerializedName("tanggapan")
    val tanggapan: String,

    @field:SerializedName("semester")
    val semester: String,

    @field:SerializedName("status_dosen_wali")
    val status_dosen_wali: String,

    @field:SerializedName("status_ketua_jurusan")
    val status_ketua_jurusan: String,

    @field:SerializedName("nim_mahasiswa")
    val nim_mahasiswa: String,

    @field:SerializedName("dosen_wali_id")
    val dosen_wali_id: String,

    @field:SerializedName("akademik_id")
    val akademik_id: String
)
