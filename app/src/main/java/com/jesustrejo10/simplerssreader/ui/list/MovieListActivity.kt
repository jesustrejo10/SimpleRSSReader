package com.jesustrejo10.simplerssreader.ui.list

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.jesustrejo10.simplerssreader.R
import com.jesustrejo10.simplerssreader.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieListActivity : BaseActivity() {

    private lateinit var viewModel: MovieListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_list_activity)
        viewModel = ViewModelProvider(this).get(MovieListViewModel::class.java)
        manageViewComponents()
        manageObservers()
        viewModel.getMovies()
    }

    override fun manageViewComponents() {
    }

    override fun manageObservers() {
    }


}