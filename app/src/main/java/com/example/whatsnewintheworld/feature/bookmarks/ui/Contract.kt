package com.example.whatsnewintheworld.feature.bookmarks.ui

import com.example.whatsnewintheworld.base.MyEvent
import com.example.whatsnewintheworld.feature.domain.ArticleModel

data class ViewState(
    val bookmarksArticle: List<ArticleModel>
)

sealed class UiEvent()
sealed class DataEvent()
