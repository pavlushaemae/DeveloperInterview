package com.itis.devinterview.model

import com.google.gson.annotations.SerializedName

data class Question(
    @SerializedName("id")
    var id: Int,
    @SerializedName("language")
    val language: String = "",
    @SerializedName("text")
    val text: String = ""
)