package com.jesustrejo10.simplerssreader.ui.list

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jesustrejo10.simplerssreader.R
import com.jesustrejo10.simplerssreader.model.data.response.Movie
import com.jesustrejo10.simplerssreader.ui.base.BaseActivity
import com.jesustrejo10.simplerssreader.ui.model.OperationStatus
import com.jesustrejo10.simplerssreader.ui.model.UiResponse
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
        getMovies()
    }

    private fun getMovies() {
        viewModel.getMovies()
    }

    override fun manageViewComponents() {
    }

    override fun manageObservers() {
        viewModel.getMoviesResponse.observe(this, Observer {
            handleResponse(it)
        })
    }

    private fun handleResponse(it: UiResponse<List<Movie>>?) {
        if(it != null){
            when(it.status){
                OperationStatus.SUCCESS -> {
                    dismissLoading()
                    handleSuccessScenario(it.value)
                }
                OperationStatus.ERROR -> {
                    dismissLoading()
                }
                OperationStatus.IN_PROGRESS ->
                    displayLoading()
            }
        }
    }

    private fun handleSuccessScenario(movieList: List<Movie>?) {
        if(movieList.isNullOrEmpty()){
            displayEmptyStatus()
        }else{
            displayList(movieList)
        }
    }

    private fun displayEmptyStatus() {
        println("")
    }

    private fun displayList(movieList: List<Movie>) {
        println("")
    }


}