package com.jesustrejo10.simplerssreader.model.usecases

import com.jesustrejo10.simplerssreader.data.remote.datasource.AuthenticationRemoteDataSource
import com.jesustrejo10.simplerssreader.model.data.request.SignUpRequest
import com.jesustrejo10.simplerssreader.model.data.response.SignUpResponse
import com.jesustrejo10.simplerssreader.model.exception.SimpleRSSException
import javax.inject.Inject

class SignUpUserUseCase @Inject constructor(private val signUpUseCaseDataSource: AuthenticationRemoteDataSource) :
    BaseAsyncUseCase<SignUpRequest, UseCaseResult<SignUpResponse?>>(){


    override suspend fun invoke(entry: SignUpRequest): UseCaseResult<SignUpResponse?> {
        return try{
            UseCaseResult.success(signUpUseCaseDataSource.signUp(entry))
        }catch (e : SimpleRSSException){
            UseCaseResult.error(e.messageToView)
        }
    }


}