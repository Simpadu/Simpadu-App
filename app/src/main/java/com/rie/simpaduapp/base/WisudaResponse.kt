package com.rie.simpaduapp.base

import com.google.gson.annotations.SerializedName
import java.time.LocalDate

data class WisudaResponse(

    @SerializedName("pengalaman_organisasi")
    val pengalaman_organisasi: String,

    @SerializedName("pengalaman_pelatihan")
    val pengalaman_pelatihan: String,

    @SerializedName("pengalaman_prestasi")
    val pengalaman_prestasi: String,

    @SerializedName("token_kuisioner")
    val token_kuisioner: String,

    @SerializedName("no_wa")
    val no_wa: Any? = null,

    @SerializedName("nama_ayah")
    val nama_ayah: String,

    @SerializedName("alamat_ortu")
    val alamat_ortu: String,

    @SerializedName("no_hp_ortu")
    val no_hp_ortu: Any? = null,

    @SerializedName("judul_tugas_akhir")
    val judul_tugas_akhir: String,

    @SerializedName("tanggal_ujian")
    val tanggal_ujian: Any? = null,

    @SerializedName("dosen_pembimbing1_id")
    val dosen_pembimbing1_id: Any? = null,

    @SerializedName("dosen_pembimbing2_id")
    val dosen_pembimbing2_id: Any? = null,

    @SerializedName("dosen_penguji1_id")
    val dosen_penguji1_id: Any? = null,

    @SerializedName("dosen_penguji2_id")
    val dosen_penguji2_id: Any? = null,

    @SerializedName("dosen_penguji3_id")
    val dosen_penguji3_id:Any?=null,

)