package com.example.coroutinesapi

import com.google.gson.annotations.SerializedName

data class DataModel(
    @SerializedName("id")
    val postID: Int,
    @SerializedName("title")
    val titleText: String,
    @SerializedName("body")
    val msgText: String
)