package com.jesustrejo10.simplerssreader.data.remote

import com.jesustrejo10.simplerssreader.data.local.StaticValues
import com.jesustrejo10.simplerssreader.model.data.request.AuthenticationRequest
import com.jesustrejo10.simplerssreader.model.data.request.SubscribeToFeedRequest
import com.jesustrejo10.simplerssreader.model.data.response.AuthenticationResponse
import com.jesustrejo10.simplerssreader.model.data.response.RssArticle
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST


interface RemoteEndPoints {

    @POST("users/login")
    fun loginRequest(@Body request: AuthenticationRequest): Call<AuthenticationResponse>

    @POST("users/register")
    fun signUpRequest(@Body request: AuthenticationRequest): Call<AuthenticationResponse>

    @POST("feeds/add")
    fun subscribeToRss(@Body request: SubscribeToFeedRequest): Call<Any>

    @GET("feeds")
    fun getArticles(): Call<List<RssArticle>>

}

