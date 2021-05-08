package com.jesustrejo10.simplerssreader.data.remote

import com.jesustrejo10.simplerssreader.model.data.request.SignUpRequest
import com.jesustrejo10.simplerssreader.model.data.response.SignUpResponse
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface RemoteEndPoints {

    @POST("users/register")
    fun signUpRequest(@Body request: SignUpRequest) : Call<SignUpResponse>

}