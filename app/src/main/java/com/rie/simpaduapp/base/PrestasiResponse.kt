package com.rie.simpaduapp.base

import com.google.gson.annotations.SerializedName
import java.time.LocalDate

data class PrestasiResponse(

    @SerializedName("nim_mahasiswa")
    val nimMahasiswa: String,

    @SerializedName("nama_prestasi")
    val namaPrestasi: String,

    @SerializedName("tingkatan_lomba")
    val tingkatanLomba: TingkatanLombaEnum,

    @SerializedName("jenis_peserta")
    val jenisPeserta: JenisPesertaEnum,

    @SerializedName("jumlah_peserta")
    val jumlahPeserta: Int,

    @SerializedName("capaian_prestasi")
    val capaianPrestasi: CapaianPrestasiEnum,

    @SerializedName("tanggal_lomba")
    val tanggalLomba: LocalDate,

    @SerializedName("pembina")
    val pembina: Int,

    @SerializedName("bukti_prestasi")
    val buktiPrestasi: String,

    )
