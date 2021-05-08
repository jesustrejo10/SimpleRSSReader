package com.jesustrejo10.simplerssreader.data.remote.repository

import com.jesustrejo10.simplerssreader.model.data.request.SignUpRequest
import com.jesustrejo10.simplerssreader.model.data.response.SignUpResponse

interface AuthenticationRepository {

    suspend fun signUp(signUpRequest: SignUpRequest) : SignUpResponse?

}