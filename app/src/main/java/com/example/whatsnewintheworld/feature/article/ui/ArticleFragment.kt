package com.example.whatsnewintheworld.feature.article.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment
import com.example.whatsnewintheworld.R
import com.example.whatsnewintheworld.feature.mainscreen.ArticlesAdapter.Companion.urlToImage
import com.example.whatsnewintheworld.feature.mainscreen.ArticlesAdapter.Companion.articleFabula
import com.squareup.picasso.Picasso

class ArticleFragment : Fragment(R.layout.fragment_article) {

    private val articlePreviewImageView: AppCompatImageView by lazy { requireActivity().findViewById(R.id.articlePreviewImageView) }
    private val tvArticleFabula: TextView by lazy { requireActivity().findViewById(R.id.tvArticleFabula) }
    private val btnClose: Button by lazy { requireActivity().findViewById(R.id.btnClose) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Picasso.get()
            .load(urlToImage)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.gasette)
            .fit()
            .into(articlePreviewImageView)

        tvArticleFabula.text = articleFabula

        btnClose.setOnClickListener {
            parentFragmentManager.beginTransaction().detach(this).commit()
        }
    }
}