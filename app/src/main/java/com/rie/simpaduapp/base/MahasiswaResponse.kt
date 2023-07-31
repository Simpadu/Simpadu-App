package com.rie.simpaduapp.base

import com.google.gson.annotations.SerializedName
import java.time.LocalDate

data class MahasiswaResponse(

    @field:SerializedName("nim")
    val nim: String,

    @field:SerializedName("nama")
    val nama: String,

    @field:SerializedName("foto_profil")
    val foto_profil: String,

    @field:SerializedName("nik")
    val nik: Char,

    @field:SerializedName("tanggal_lahir")
    val tanggal_lahir: LocalDate,

    @field:SerializedName("tempat_lahir")
    val tempat_lahir: String,

    @field:SerializedName("no_hp")
    val no_hp: String,

    @field:SerializedName("email")
    val email: String,

    @field:SerializedName("alamat")
    val alamat: String,

    @field:SerializedName("semester")
    val semester: Byte,

    @field:SerializedName("nama_ibu")
    val nama_ibu: String,

    @field:SerializedName("nama_ayah")
    val nama_ayah: String,

    @field:SerializedName("kode_pos")
    val kode_pos: Char,

    @field:SerializedName("kecamatan")
    val kecamatan: String,

    @field:SerializedName("kelurahan")
    val kelurahan: String,

    @field:SerializedName("virtual_account")
    val virtual_account: String,

    @field:SerializedName("status_mahasiswa")
    val status_mahasiswa: String,

    @field:SerializedName("kelas_id")
    val kelas_id: Int,

    @field:SerializedName("agama_id")
    val agama_id: Int,

    @field:SerializedName("dosen_wali")
    val dosen_wali: Int,

    @field:SerializedName("status")
    val status: String,

    )