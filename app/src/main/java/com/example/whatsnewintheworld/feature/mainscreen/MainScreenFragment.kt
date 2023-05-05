package com.example.whatsnewintheworld.feature.mainscreen

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.widget.AutoCompleteTextView
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsnewintheworld.R
import com.example.whatsnewintheworld.feature.article.ui.ArticleFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.zip.Inflater

class MainScreenFragment : Fragment(R.layout.fragment_main_screen){

    private val viewModel: MainScreenViewModel by viewModel()
    private val recyclerView: RecyclerView by lazy { requireActivity().findViewById(R.id.rvArticles) }
    private val ivSearch: ImageView by lazy {requireActivity().findViewById(R.id.ivSearch)}
    private val tvAppTitle: TextView by lazy {requireActivity().findViewById(R.id.tvAppTitle)}
    private val actvSearch: AutoCompleteTextView by lazy {requireActivity().findViewById(R.id.actvSearch)}
    private val adapter: ArticlesAdapter by lazy {
        ArticlesAdapter {index ->
            viewModel.processUiEvent(UiEvent.OnArticleClicked(this))
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.viewState.observe(viewLifecycleOwner, ::render)
        recyclerView.adapter = adapter

        ivSearch.setOnClickListener {
            viewModel.processUiEvent(UiEvent.OnSearchButtonClicked)
        }

        actvSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(text: Editable?) {
                viewModel.processUiEvent(UiEvent.OnSearchEdited(text.toString()))
            }
        })
    }


    private fun render(viewState: ViewState) {
        tvAppTitle.isVisible = !viewState.isSearchEnabled
        actvSearch.isVisible = viewState.isSearchEnabled
        adapter.setData(viewState.articlesShown)
        }
    }