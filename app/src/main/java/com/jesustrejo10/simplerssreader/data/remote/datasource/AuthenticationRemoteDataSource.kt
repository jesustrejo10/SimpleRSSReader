package com.jesustrejo10.simplerssreader.data.remote.datasource

import com.jesustrejo10.simplerssreader.data.remote.RemoteEndPoints
import com.jesustrejo10.simplerssreader.data.remote.repository.AuthenticationRepository
import com.jesustrejo10.simplerssreader.model.data.request.AuthenticationRequest
import com.jesustrejo10.simplerssreader.model.data.response.AuthenticationResponse
import retrofit2.await
import java.lang.Exception
import javax.inject.Inject

class AuthenticationRemoteDataSource @Inject constructor(
    private val apiDefinitionService: RemoteEndPoints) :
    BaseDataSource(), AuthenticationRepository
{
    override suspend fun login(loginRequest: AuthenticationRequest): AuthenticationResponse? {
        try{
            return apiDefinitionService.loginRequest(loginRequest).await()
        }catch (e :Exception){
            throw manageError(e)
        }
    }

    override suspend fun signUp(authenticationRequest: AuthenticationRequest): AuthenticationResponse {
        try{
            return apiDefinitionService.signUpRequest(authenticationRequest).await()
        }catch (e :Exception){
            throw manageError(e)
        }
    }

}