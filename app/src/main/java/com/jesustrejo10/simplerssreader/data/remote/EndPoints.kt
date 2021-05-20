package com.jesustrejo10.simplerssreader.data.remote

import com.jesustrejo10.simplerssreader.model.data.request.AuthenticationRequest
import com.jesustrejo10.simplerssreader.model.data.request.SubscribeToFeedRequest
import com.jesustrejo10.simplerssreader.model.data.response.AuthenticationResponse
import com.jesustrejo10.simplerssreader.model.data.response.GetMoviesResponse
import com.jesustrejo10.simplerssreader.model.data.response.RssArticle
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


interface EndPoints {

    @POST("users/login")
    fun loginRequest(@Body request: AuthenticationRequest): Call<AuthenticationResponse>

    @POST("users/register")
    fun signUpRequest(@Body request: AuthenticationRequest): Call<AuthenticationResponse>

    @POST("feeds/add")
    fun subscribeToRss(@Body request: SubscribeToFeedRequest): Call<Any>

    @GET("articles/upcoming")
    fun getArticles(): Call<List<RssArticle>>

    @GET("movie/upcoming")
    fun getMovies(@Query ("api_key") apiKey: String): Call<GetMoviesResponse>
}

