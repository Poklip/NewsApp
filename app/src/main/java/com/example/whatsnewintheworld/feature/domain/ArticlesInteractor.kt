package com.example.whatsnewintheworld.feature.domain

import com.example.whatsnewintheworld.base.attempt
import com.example.whatsnewintheworld.feature.data.ArticlesRepository

class ArticlesInteractor(private val articlesRepository: ArticlesRepository) {

    suspend fun getArticles() = attempt { articlesRepository.getArticles() }
}