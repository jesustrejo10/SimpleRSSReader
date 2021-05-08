package com.jesustrejo10.simplerssreader.ui.feed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.jesustrejo10.simplerssreader.R
import com.jesustrejo10.simplerssreader.model.data.response.RssArticle

class FeedAdapter(private val articles : List<RssArticle>,
                    private val contract : ArticleListContract) : RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        return LayoutInflater.from(parent.context).inflate(R.layout.layout_card_article, parent, false).let {
            FeedViewHolder(it)
        }
    }

    override fun getItemCount(): Int = articles.size

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        val article = articles.getOrNull(position) ?: return
        holder.bind(article)
        holder.mainHoder.setOnClickListener{
            contract.onArticleClick(article)
        }
    }

    class FeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val title = itemView.findViewById<TextView>(R.id.title)
        val mainHoder = itemView.findViewById<CardView>(R.id.mainLayout)

        fun bind(rssArticle: RssArticle){
            title.text = rssArticle.title
        }
    }
}