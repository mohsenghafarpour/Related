package com.karafs.related.data

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("lastName")
    val lastName: String
)