package com.jesustrejo10.simplerssreader.ui.list

import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.jesustrejo10.simplerssreader.R
import com.jesustrejo10.simplerssreader.model.data.response.Movie
import com.jesustrejo10.simplerssreader.ui.base.BaseGenericListAdapter
import com.jesustrejo10.simplerssreader.ui.base.BaseItemAdapterListener
import com.jesustrejo10.simplerssreader.ui.base.BaseViewHolder
import kotlinx.android.synthetic.main.layout_movie_card.view.*

class MovieListAdapter (movieList : List<Movie>) :
    BaseGenericListAdapter<Movie, BaseViewHolder<Movie>>(
    items = movieList
) {

    companion object{
        const val ENDPOINT_IMAGE = "https://image.tmdb.org/t/p/w500"

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Movie> =
        MovieViewHolder(parent)

    inner class MovieViewHolder(val parent : ViewGroup) :
        BaseViewHolder<Movie>(layoutId = R.layout.layout_movie_card,parent = parent){

        override fun bind(item: Movie, listener: BaseItemAdapterListener<Movie>?) {
            itemView.movieTitle.text = item.title
            itemView.movieOverview.text = item.overview
            Glide.with(parent.context)
                .load(ENDPOINT_IMAGE+item.backdrop_path)
                .into(itemView.movieImage)
        }

    }

}