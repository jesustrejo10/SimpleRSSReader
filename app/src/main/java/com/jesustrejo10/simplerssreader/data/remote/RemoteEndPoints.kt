package com.jesustrejo10.simplerssreader.data.remote

import com.jesustrejo10.simplerssreader.core.model.data.requests.SignUpRequest
import com.jesustrejo10.simplerssreader.core.model.data.responses.SignUpResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.Body
import retrofit2.http.POST


interface RemoteEndPoints {


    @POST("users/register")
    fun signUpRequest(@Body request: SignUpRequest) : Deferred<SignUpResponse>


}