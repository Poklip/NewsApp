package com.example.whatsnewintheworld.feature.bookmarks.ui

import com.example.whatsnewintheworld.base.BaseViewModel
import com.example.whatsnewintheworld.base.MyEvent
import com.example.whatsnewintheworld.feature.bookmarks.domain.BookmarksInteractor

class BookmarksScreenViewModel(private val interactor: BookmarksInteractor): BaseViewModel<ViewState>() {
    override fun initialViewState() = ViewState(bookmarksArticle = emptyList())

    override fun reduce(event: MyEvent, previousState: ViewState): ViewState? {
        return null
    }
}