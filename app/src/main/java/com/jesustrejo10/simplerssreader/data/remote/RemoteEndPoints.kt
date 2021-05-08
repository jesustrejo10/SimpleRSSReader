package com.jesustrejo10.simplerssreader.data.remote

import com.jesustrejo10.simplerssreader.model.data.request.AuthenticationRequest
import com.jesustrejo10.simplerssreader.model.data.response.AuthenticationResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface RemoteEndPoints {

    @POST("users/login")
    fun loginRequest(@Body request: AuthenticationRequest) : Call<AuthenticationResponse>

    @POST("users/register")
    fun signUpRequest(@Body request: AuthenticationRequest) : Call<AuthenticationResponse>

}