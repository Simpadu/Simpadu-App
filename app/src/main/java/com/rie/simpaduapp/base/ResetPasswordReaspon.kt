package com.rie.simpaduapp.base

import com.google.gson.annotations.SerializedName

data class ResetEmailReaspon (
    @SerializedName("nim")
    val nim: String,

    @SerializedName("keterangan")
    val keterangan: String,

)