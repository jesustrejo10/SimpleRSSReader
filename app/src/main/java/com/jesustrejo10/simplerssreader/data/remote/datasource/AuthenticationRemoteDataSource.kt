package com.jesustrejo10.simplerssreader.data.remote.datasource

import com.jesustrejo10.simplerssreader.data.remote.RemoteEndPoints
import com.jesustrejo10.simplerssreader.data.remote.repository.AuthenticationRepository
import com.jesustrejo10.simplerssreader.model.data.request.SignUpRequest
import com.jesustrejo10.simplerssreader.model.data.response.SignUpResponse
import retrofit2.await
import java.lang.Exception
import javax.inject.Inject

class AuthenticationRemoteDataSource @Inject constructor(
    private val apiDefinitionService: RemoteEndPoints) :
    BaseDataSource(), AuthenticationRepository
{
    override suspend fun signUp(signUpRequest: SignUpRequest): SignUpResponse {
        try{
            return apiDefinitionService.signUpRequest(signUpRequest).await()
        }catch (e :Exception){
            throw manageError(e)
        }
    }

}