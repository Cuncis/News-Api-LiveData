package com.cuncis.retrofitlivedataexample.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cuncis.retrofitlivedataexample.R
import com.cuncis.retrofitlivedataexample.model.Articles
import kotlinx.android.synthetic.main.item_news.view.*

class NewsAdapter(private var context: Context): RecyclerView.Adapter<NewsAdapter.NewsHolder>() {

    private var newsList = ArrayList<Articles>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_news, parent, false)
        return NewsHolder(view)
    }

    override fun getItemCount(): Int = newsList.size

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        holder.tvName.text = newsList[position].title
        holder.tvDesc.text = newsList[position].description
        Glide.with(context)
            .load(newsList[position].urlToImage)
            .centerCrop()
            .into(holder.newsPoster)
    }

    fun setNewsList(newsList: ArrayList<Articles>) {
        this.newsList = newsList
        notifyDataSetChanged()
    }

    inner class NewsHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.tvName
        var tvDesc: TextView = itemView.tvDesCription
        var newsPoster: ImageView = itemView.ivNews
    }

}