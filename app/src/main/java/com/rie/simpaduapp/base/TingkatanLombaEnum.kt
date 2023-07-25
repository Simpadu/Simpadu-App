package com.rie.simpaduapp.base

import com.google.gson.annotations.SerializedName

enum class TingkatanLombaEnum {
    @SerializedName("Internasional")
    INTERNASIONAL,

    @SerializedName("Nasional")
    NASIONAL,

    @SerializedName("Provinsi")
    PROVINSI,

    @SerializedName("Kabupaten")
    KABUPATEN,

    @SerializedName("Kecamatan")
    KECAMATAN,

    @SerializedName("Kelurahan")
    KELURAHAN,

    @SerializedName("RT/RW")
    RT_RW,

    @SerializedName("Tanpa Tingkatan")
    TANPA_TINGKATAN
}
