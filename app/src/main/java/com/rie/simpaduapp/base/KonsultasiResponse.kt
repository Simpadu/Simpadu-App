package com.rie.simpaduapp.base

import com.google.gson.annotations.SerializedName

data class KonsultasiResponse(

    @SerializedName("nim_mahasiswa")
    val nimMahasiswa: String,

    @SerializedName("semester")
    val Semester: Byte,

    @SerializedName("keterangan")
    val Keterangan: String,

    @SerializedName("tanggapan")
    val Tanggapan: String,

    @SerializedName("dosen_wali_id")
    val DosenWali: Int,

    @SerializedName("status_dosen_wali")
    val statusDosenWali: Boolean,

    @SerializedName("status_ketua_jurusan")
    val statusKetuaJurusan:Boolean,

    )