package com.jesustrejo10.simplerssreader.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jesustrejo10.simplerssreader.model.usecases.GetMovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(val getMoviesUseCase: GetMovieListUseCase) : ViewModel(){


    fun getMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            getMoviesUseCase.invoke(Unit)
        }
    }


}