package com.example.whatsnewintheworld.feature.mainscreen

import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsnewintheworld.R
import com.example.whatsnewintheworld.feature.domain.ArticleModel

class ArticlesAdapter (private val onItemClicked: (Int) -> Unit) : RecyclerView.Adapter<ArticlesAdapter.ViewHolder>() {


    companion object {
        var urlToImage: String = ""
        var articleFabula: String = ""
        var urlToSource: String = ""
    }

    private var articlesData: List<ArticleModel> = emptyList()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val textViewTitle: TextView
        val textViewSourceName: TextView
        val textViewPublishedAt: TextView
        init {
            textViewTitle  = view.findViewById(R.id.tvTitle)
            textViewSourceName = view.findViewById(R.id.tvSourceName)
            textViewPublishedAt = view.findViewById(R.id.tvPublishedAt)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_article, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.itemView.setOnClickListener{
            onItemClicked.invoke(position)
            urlToImage = articlesData[position].urlToImage.toString()
            articleFabula = articlesData[position].title
            urlToSource = articlesData[position].url
        }


        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.textViewSourceName.text = articlesData[position].source
        viewHolder.textViewTitle.text = articlesData[position].title
        viewHolder.textViewPublishedAt.text = articlesData[position].publishedAt


    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = articlesData.size

    fun setData(articles: List<ArticleModel>) {
        articlesData = articles
        notifyDataSetChanged()
    }

}
