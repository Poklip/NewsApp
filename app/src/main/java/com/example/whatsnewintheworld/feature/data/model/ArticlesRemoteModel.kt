package com.example.whatsnewintheworld.feature.data.model

import com.google.gson.annotations.SerializedName

data class ArticlesRemoteModel (
    @SerializedName("articles")
    val articleList: List<ArticleRemoteModel>
)