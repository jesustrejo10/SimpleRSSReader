package com.jesustrejo10.simplerssreader.model.usecases

import com.jesustrejo10.simplerssreader.data.remote.datasource.AuthenticationRemoteDataSource
import com.jesustrejo10.simplerssreader.model.data.request.AuthenticationRequest
import com.jesustrejo10.simplerssreader.model.data.response.AuthenticationResponse
import com.jesustrejo10.simplerssreader.model.exception.SimpleRSSException
import javax.inject.Inject

class SignUpUserUseCase @Inject constructor(private val signUpUseCaseDataSource: AuthenticationRemoteDataSource) :
    BaseAsyncUseCase<AuthenticationRequest, UseCaseResult<AuthenticationResponse?>>(){


    override suspend fun invoke(entry: AuthenticationRequest): UseCaseResult<AuthenticationResponse?> {
        return try{
            UseCaseResult.success(signUpUseCaseDataSource.signUp(entry))
        }catch (e : SimpleRSSException){
            UseCaseResult.error(e.messageToView)
        }
    }


}