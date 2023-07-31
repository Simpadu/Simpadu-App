package com.rie.simpaduapp.base

import com.google.gson.annotations.SerializedName

data class AuthResponse(

    @field:SerializedName("accessToken")
    val accessToken: String,

    @field:SerializedName("nim")
    val nim:String,

    )