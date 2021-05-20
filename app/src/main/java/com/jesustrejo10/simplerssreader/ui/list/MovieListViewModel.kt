package com.jesustrejo10.simplerssreader.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jesustrejo10.simplerssreader.model.data.response.Movie
import com.jesustrejo10.simplerssreader.model.usecases.GetMovieListUseCase
import com.jesustrejo10.simplerssreader.model.viewData.SourceType
import com.jesustrejo10.simplerssreader.ui.base.BaseActivity.Companion.OFF_LINE
import com.jesustrejo10.simplerssreader.ui.model.UiResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(private val getMoviesUseCase: GetMovieListUseCase) : ViewModel(){

    private val _movieList = MutableLiveData<UiResponse<List<Movie>>>()
    val getMoviesResponse: LiveData<UiResponse<List<Movie>>>
        get() = _movieList

    fun getMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            _movieList.postValue(UiResponse.loading())
            val useCaseResult =getMoviesUseCase.invoke(Unit)
            if(useCaseResult.success && useCaseResult.value != null){
                when(useCaseResult.value.sourceType){
                    SourceType.INTERNET -> {
                        _movieList.postValue(UiResponse.success(useCaseResult.value.movieList))
                    }
                    SourceType.CACHE -> {
                        _movieList.postValue(UiResponse.success(useCaseResult.value.movieList,OFF_LINE))
                    }
                }
            }else{
                _movieList.postValue(UiResponse.error(useCaseResult.errorMessage))
            }
        }
    }


}