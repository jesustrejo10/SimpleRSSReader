package com.jesustrejo10.simplerssreader.data.remote.datasource

import com.jesustrejo10.simplerssreader.model.exception.SimpleRSSException
import retrofit2.HttpException
import java.lang.Exception

abstract class BaseDataSource {

    fun manageError(e : Exception) : SimpleRSSException {
        when (e ){
            is HttpException -> {
                if(e.code() == 401){
                    //unauthorized but in this API that also happens when you repeat an user /psw to sign Up
                    return SimpleRSSException(e, "This user is already taken, try with a new one")
                }
            }
        }
        return SimpleRSSException(e, "Unexpected Error, please contact support.")
    }
}