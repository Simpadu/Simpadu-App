package com.rie.simpaduapp.base

import com.google.gson.annotations.SerializedName

data class DefaultResponse(
    @field:SerializedName("status")
    val status: String,

    @field:SerializedName("message")
    val message:String
)