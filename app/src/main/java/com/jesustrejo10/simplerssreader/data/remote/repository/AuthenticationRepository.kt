package com.jesustrejo10.simplerssreader.data.remote.repository

import com.jesustrejo10.simplerssreader.model.data.request.AuthenticationRequest
import com.jesustrejo10.simplerssreader.model.data.response.AuthenticationResponse

interface AuthenticationRepository {

    suspend fun login (loginRequest : AuthenticationRequest) : AuthenticationResponse?

    suspend fun signUp(authenticationRequest: AuthenticationRequest) : AuthenticationResponse?

}