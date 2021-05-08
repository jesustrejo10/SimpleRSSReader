package com.jesustrejo10.simplerssreader.ui.feed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jesustrejo10.simplerssreader.R
import com.jesustrejo10.simplerssreader.model.data.response.RssArticle

class FeedAdapter(private val articles : List<RssArticle>) : RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {


    class FeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        return LayoutInflater.from(parent.context).inflate(R.layout.layout_card_article, parent, false).let {
            FeedViewHolder(it)
        }
    }


    override fun getItemCount(): Int = articles.size


    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        println()
    }
}