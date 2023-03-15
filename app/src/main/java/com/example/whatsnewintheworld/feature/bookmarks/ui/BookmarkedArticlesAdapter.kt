package com.example.whatsnewintheworld.feature.bookmarks.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsnewintheworld.R
import com.example.whatsnewintheworld.feature.domain.ArticleModel

class BookmarkedArticlesAdapter(val onItemClicked: (Int) -> Unit) : RecyclerView.Adapter<BookmarkedArticlesAdapter.ViewHolder>() {

    private var bookmarkedArticlesData: List<ArticleModel> = emptyList()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewTitleBMA: TextView
        val textViewSourceNameBMA: TextView

        init {
            textViewTitleBMA = view.findViewById(R.id.tvBookmarkedArticleTitle)
            textViewSourceNameBMA = view.findViewById(R.id.tvBookmarkedArticleSource)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_bookmarked_article, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: BookmarkedArticlesAdapter.ViewHolder, position: Int) {

        viewHolder.itemView.setOnClickListener{
            onItemClicked.invoke(position)
        }

        viewHolder.textViewTitleBMA.text = bookmarkedArticlesData[position].title
        viewHolder.textViewSourceNameBMA.text = bookmarkedArticlesData[position].source
    }

    override fun getItemCount() = bookmarkedArticlesData.size

    fun setData(articles: List<ArticleModel>) {
        bookmarkedArticlesData = articles
        notifyDataSetChanged()
    }
}