package com.itis.devinterview.model

import com.google.gson.annotations.SerializedName

data class Question(
    @SerializedName("id")
    var id: Int,
    @SerializedName("language")
    val language: String = "",
    @SerializedName("question")
    val question: String = "",
    @SerializedName("first")
    val first: String = "",
    @SerializedName("second")
    val second: String = "",
    @SerializedName("third")
    val third: String = "",
    @SerializedName("fourth")
    val fourth: String = "",
    @SerializedName("correct")
    val correct: String = "",
)