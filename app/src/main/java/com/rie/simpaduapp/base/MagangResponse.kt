package com.rie.simpaduapp.base

import com.google.gson.annotations.SerializedName

data class MagangResponse(
    @SerializedName("id")
    val id: Int,

    @SerializedName("nim_mahasiswa")
    val nim_mahasiswa: String,

    @SerializedName("nama")
    val nama: String,

    @SerializedName("judul")
    val judul: String,

    @SerializedName("tempat_magang")
    val tempat_magang: String,

    @SerializedName("dosen_pembimbing1_id")
    val dosen_pembimbing1_id: Int,

    @SerializedName("dosen_pembimbing2_id")
    val dosen_pembimbing2_id: Int,

    @SerializedName("dosen_penguji1_id")
    val dosen_penguji1_id: Int,

    @SerializedName("dosen_penguji2_id")
    val dosen_penguji2_id:Int,

    )