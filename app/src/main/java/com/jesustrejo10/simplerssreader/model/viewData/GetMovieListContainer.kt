package com.jesustrejo10.simplerssreader.model.viewData

import com.jesustrejo10.simplerssreader.model.data.response.Movie

data class GetMovieListContainer (
    val sourceType :SourceType, val movieList : List<Movie>, val message : String = "")