package com.example.whatsnewintheworld.feature.bookmarks.ui

import com.example.whatsnewintheworld.base.MyEvent
import com.example.whatsnewintheworld.feature.domain.ArticleModel

data class ViewState(
    val bookmarksArticle: List<ArticleModel>
)

sealed class UiEvent : MyEvent {
    data class OnArticleClicked(val index: Int) : UiEvent()
}
sealed class DataEvent : MyEvent {
    object LoadBookmarks : DataEvent()
    data class OnSuccessBookmarksLoaded(val bookmarksLoaded: List<ArticleModel>) : DataEvent()
    data class OnFailureBookmarksLoaded(val throwable: Throwable) : DataEvent()
}
