package com.example.whatsnewintheworld.feature.article.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment
import com.example.whatsnewintheworld.R
import com.example.whatsnewintheworld.feature.mainscreen.ArticlesAdapter.Companion.urlToImage
import com.example.whatsnewintheworld.feature.mainscreen.ArticlesAdapter.Companion.articleFabula
import com.example.whatsnewintheworld.feature.mainscreen.ArticlesAdapter.Companion.urlToSource
import com.squareup.picasso.Picasso

class ArticleFragment : Fragment(R.layout.fragment_article) {

    private val articlePreviewImageView: AppCompatImageView by lazy { requireActivity().findViewById(R.id.articlePreviewImageView) }
    private val tvArticleFabula: TextView by lazy { requireActivity().findViewById(R.id.tvArticleFabula) }
    private val tvImageSource: TextView by lazy { requireActivity().findViewById(R.id.tvImageSource) }
    private val btnClose: Button by lazy { requireActivity().findViewById(R.id.btnClose) }
    private val btnGoToSource: Button by lazy { requireActivity().findViewById(R.id.btnGoToSource) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //val browserIntent =

        Picasso.get()
            .load(urlToImage)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.background_placeholder_by_ai)
            .fit()
            .into(articlePreviewImageView)

        tvArticleFabula.text = articleFabula

        if (urlToImage != "null") tvImageSource.text = "Image source: $urlToImage" else tvImageSource.text = "https://www.bing.com/images/create?FORM=GENILP"

        btnGoToSource.setOnClickListener {
            requireActivity().startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(urlToSource)))
        }

        btnClose.setOnClickListener {
            parentFragmentManager.beginTransaction().detach(this).commit()
        }
    }
}