package com.example.whatsnewintheworld.feature.data

import com.example.whatsnewintheworld.feature.domain.ArticleModel

interface ArticlesRepository {
    suspend fun getArticles() : List<ArticleModel>
}