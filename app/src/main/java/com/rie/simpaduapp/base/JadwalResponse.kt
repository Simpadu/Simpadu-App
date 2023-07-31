package com.rie.simpaduapp.base

import android.text.format.Time
import com.google.gson.annotations.SerializedName

data class JadwalResponse(

    @SerializedName("nim_mahasiswa")
    val nimMahasiswa: String,

    @SerializedName("semester")
    val Semester: Byte,

    @SerializedName("nama_matkul_id")
    val namaMatkul: Int,

    @SerializedName("nama_hari")
    val nama_hari: String,

    @SerializedName("ruangan_id")
    val ruanganId: Int,

    @SerializedName("jam_mulai")
    val jamMulai: Time,

    @SerializedName("jam_selesai")
    val jamSelesai: Time,

    @SerializedName("pengajar_id")
    val pengajar:Int,

    )