package com.jesustrejo10.simplerssreader.data.remote.datasource

import com.jesustrejo10.simplerssreader.model.exception.SimpleRSSException
import retrofit2.HttpException
import java.lang.Exception

abstract class BaseDataSource {

    fun manageError(e: Exception): SimpleRSSException {
        when (e) {
            is HttpException -> {
                when (e.code()) {
                    401 -> {
                        //unauthorized but in this API that also happens when you repeat an user /psw to sign Up
                        return SimpleRSSException(e, "This user is already taken try with a new one")
                    }
                    400 -> {
                        //Bad request but in this API that means (wrong password)
                        // also means that the user doesn't exist.
                        return SimpleRSSException(e, "Invalid password or the entered user doesn't exist.")
                    }
                }
            }
        }
        return SimpleRSSException(e, "Unexpected Error, please contact support.")
    }
}