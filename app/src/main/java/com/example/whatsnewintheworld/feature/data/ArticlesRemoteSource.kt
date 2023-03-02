package com.example.whatsnewintheworld.feature.data

import com.example.whatsnewintheworld.feature.data.model.ArticlesRemoteModel

class ArticlesRemoteSource (private val api: NewsApi) {
    suspend fun getArticles(): ArticlesRemoteModel {
        return api.getArticles()
    }
}