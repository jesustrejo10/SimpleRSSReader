package com.jesustrejo10.simplerssreader.ui.list

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jesustrejo10.simplerssreader.R
import com.jesustrejo10.simplerssreader.model.data.response.Movie
import com.jesustrejo10.simplerssreader.ui.base.BaseActivity
import com.jesustrejo10.simplerssreader.ui.model.OperationStatus
import com.jesustrejo10.simplerssreader.ui.model.UiResponse
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.movie_list_activity.*

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
                    dismissEmptyStatus()
                    dismissLoading()
                    handleSuccessScenario(it.value,it.message)
                }
                OperationStatus.ERROR -> {
                    dismissLoading()
                    displayEmptyStatus()
                }
                OperationStatus.IN_PROGRESS ->
                    displayLoading()
            }
        }
    }

    private fun handleSuccessScenario(movieList: List<Movie>?, message: String) {
        if(movieList.isNullOrEmpty()){
            displayEmptyStatus()
        }else{
            displayList(movieList)
            if(message.isNotEmpty())
                displayNoInternet()
            else
                dismissNoInternet()
        }
    }


    private fun dismissNoInternet() {
        no_internet.visibility = View.GONE
    }

    private fun displayNoInternet() {
        no_internet.visibility = View.VISIBLE
    }

    private fun displayEmptyStatus() {
        no_internet_and_no_data.visibility = View.VISIBLE
    }

    private fun dismissEmptyStatus() {
        no_internet_and_no_data.visibility = View.GONE
    }


    private fun displayList(movieList: List<Movie>) {
        val adapter = MovieListAdapter(movieList)
        movieListRecyclerView.layoutManager = LinearLayoutManager(this)
        movieListRecyclerView.adapter = adapter
    }


}