package com.example.whatsnewintheworld.feature.data.model

import com.google.gson.annotations.SerializedName
import java.io.FileDescriptor

data class ArticleRemoteModel(
    @SerializedName("author")
    val author: String?,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String?,
    @SerializedName("url")
    val url: String,
    @SerializedName("publishedAt")
    val publishedAt: String
)