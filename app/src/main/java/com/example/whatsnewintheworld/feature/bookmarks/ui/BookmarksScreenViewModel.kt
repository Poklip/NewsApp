package com.example.whatsnewintheworld.feature.bookmarks.ui

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.whatsnewintheworld.base.BaseViewModel
import com.example.whatsnewintheworld.base.MyEvent
import com.example.whatsnewintheworld.feature.bookmarks.domain.BookmarksInteractor
import com.example.whatsnewintheworld.feature.mainscreen.UiEvent
import kotlinx.coroutines.launch

class BookmarksScreenViewModel(private val interactor: BookmarksInteractor): BaseViewModel<ViewState>() {

    init {
        processDataEvent(DataEvent.LoadBookmarks)
    }
    override fun initialViewState() = ViewState(bookmarksArticle = emptyList())

    override fun reduce(event: MyEvent, previousState: ViewState): ViewState? {
        when (event) {
            is DataEvent.LoadBookmarks -> {
                viewModelScope.launch {
                    interactor.read().fold(
                        onError = {
                            Log.e("ERROR", it.localizedMessage)
                        },
                        onSuccess = {
                            processDataEvent(DataEvent.OnSuccessBookmarksLoaded(it))
                        }
                    )
                }
                return null
            }

            is DataEvent.OnSuccessBookmarksLoaded -> {
                return previousState.copy(bookmarksArticle = event.bookmarksLoaded)
            }

            is UiEvent.OnArticleClicked -> {
                return null
            }

            else -> return null
        }
    }
}