package com.rie.simpaduapp.base

import com.google.gson.annotations.SerializedName
import java.time.LocalDate

data class MahasiswaResponse(

    @field:SerializedName("nim")
    val nim: String? = null,

    @field:SerializedName("nama")
    val nama: String? = null,

    @field:SerializedName("foto_profil")
    val foto_profil: String? = null,

    @field:SerializedName("nik")
    val nik: Char? = null,

    @field:SerializedName("tanggal_lahir")
    val tanggal_lahir: LocalDate? = null,

    @field:SerializedName("tempat_lahir")
    val tempat_lahir: String? = null,

    @field:SerializedName("no_hp")
    val no_hp: String? = null,

    @field:SerializedName("email")
    val email: String? = null,

    @field:SerializedName("alamat")
    val alamat: String? = null,

    @field:SerializedName("semester")
    val semester: Byte? = null,

    @field:SerializedName("nama_ibu")
    val nama_ibu: String? = null,

    @field:SerializedName("nama_ayah")
    val nama_ayah: String? = null,

    @field:SerializedName("kode_pos")
    val kode_pos: Char? = null,

    @field:SerializedName("kecamatan")
    val kecamatan: String? = null,

    @field:SerializedName("kelurahan")
    val kelurahan: String? = null,

    @field:SerializedName("virtual_account")
    val virtual_account: String? = null,

    @field:SerializedName("status_mahasiswa")
    val status_mahasiswa: String? = null,

    @field:SerializedName("kelas_id")
    val kelas_id: Int? = null,

    @field:SerializedName("agama_id")
    val agama_id: Int? = null,

    @field:SerializedName("dosen_wali")
    val dosen_wali: Int? = null,

    @field:SerializedName("status")
    val status: String?=null,

    )