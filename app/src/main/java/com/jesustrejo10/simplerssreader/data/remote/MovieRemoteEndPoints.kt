package com.jesustrejo10.simplerssreader.data.remote

import com.jesustrejo10.simplerssreader.model.data.response.GetMoviesResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieRemoteEndPoints {

    @GET("movie/upcoming")
    fun getArticles(): Call<GetMoviesResponse>
}