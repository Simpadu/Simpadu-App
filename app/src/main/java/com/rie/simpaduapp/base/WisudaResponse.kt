package com.rie.simpaduapp.base

import com.google.gson.annotations.SerializedName
import java.time.LocalDate

data class WisudaResponse(

    @SerializedName("nim_mahasiswa")
    val nimMahasiswa: String,

    @SerializedName("pengalaman_organisasi")
    val pengalamanOrganisasi: String,

    @SerializedName("pengalaman_pelatihan")
    val pengalamanPelatihan: String,

    @SerializedName("pengalaman_prestasi")
    val pengalamanPrestasi: String,

    @SerializedName("token_kuisioner")
    val tokenKuisioner: String,

    @SerializedName("no_wa")
    val noWa: Int,

    @SerializedName("nama_ayah")
    val namaAyah: String,

    @SerializedName("alamat_ortu")
    val alamatOrtu: String,

    @SerializedName("no_hp_ortu")
    val noHpOrtu: Int,

    @SerializedName("judul_tugas_akhir")
    val judulTA: String,

    @SerializedName("tanggal_ujian")
    val tanggalUjian: LocalDate,

    @SerializedName("dosen_pembimbing1_id")
    val dosenPembimbing1: Int,

    @SerializedName("dosen_pembimbing2_id")
    val dosenPembimbing2: Int,

    @SerializedName("dosen_penguji1_id")
    val dosenPenguji1: Int,

    @SerializedName("dosen_penguji2_id")
    val dosenPenguji2: Int,

    @SerializedName("dosen_penguji3_id")
    val dosenPenguji3:Int,

    )