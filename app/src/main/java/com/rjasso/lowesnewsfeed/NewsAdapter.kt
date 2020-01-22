package com.rjasso.lowesnewsfeed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.rjasso.lowesnewsfeed.model.data.Article
import kotlinx.android.synthetic.main.new_layout.view.*

class NewsAdapter(val news: ArrayList<Article>) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.new_layout, parent, false)
        return NewsViewHolder(view)
    }

    override fun getItemCount() = news.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val articule: Article = news.get(position)
        holder.itemView.imageView.load(articule.urlToImage)
        holder.itemView.authorTextView.text = articule.author
        holder.itemView.titleTextView.text = articule.title
        holder.itemView.sourceTextView.text = articule.source.name
    }


    fun updateNews(newsUpdated: List<Article>) {
        news.clear()
        news.addAll(newsUpdated)
        notifyDataSetChanged()
    }
    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}
