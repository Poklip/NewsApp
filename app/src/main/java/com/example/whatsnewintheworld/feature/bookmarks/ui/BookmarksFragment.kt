package com.example.whatsnewintheworld.feature.bookmarks.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsnewintheworld.R
import com.example.whatsnewintheworld.feature.mainscreen.ArticlesAdapter
import com.example.whatsnewintheworld.feature.mainscreen.MainScreenViewModel
import com.example.whatsnewintheworld.feature.mainscreen.ViewState
import org.koin.androidx.viewmodel.ext.android.viewModel

class BookmarksFragment : Fragment(R.layout.fragment_bookmarks) {
    private val viewModel: MainScreenViewModel by viewModel()
    private val recyclerView: RecyclerView by lazy { requireActivity().findViewById(R.id.rvBookmarkedArticles) }
    private val adapter: ArticlesAdapter by lazy { ArticlesAdapter() }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //viewModel.viewState.observe(viewLifecycleOwner, ::render)
        recyclerView.adapter = adapter
    }

    /*private fun render(viewState: ViewState) {
        adapter.setData(viewState.articles)
    }*/
}