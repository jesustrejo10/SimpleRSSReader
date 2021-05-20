package com.jesustrejo10.simplerssreader.data.remote.repository

import com.jesustrejo10.simplerssreader.model.data.response.GetMoviesResponse

interface MoviesRepository {

    suspend fun getMovies(): GetMoviesResponse
}