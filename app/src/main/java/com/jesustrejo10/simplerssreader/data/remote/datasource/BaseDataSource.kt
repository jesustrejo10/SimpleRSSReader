package com.jesustrejo10.simplerssreader.data.remote.datasource

import com.jesustrejo10.simplerssreader.model.exception.MoviesException
import com.jesustrejo10.simplerssreader.model.exception.SimpleRSSException
import retrofit2.HttpException
import java.lang.Exception
import java.net.UnknownHostException

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

    fun manageErrorFromMovies(e: Exception): MoviesException {
        when (e) {
            is HttpException -> {
                when (e.code()) {
                    401 -> {
                        //unauthorized
                        return MoviesException(e, "The entered key, isn't valid anymore. Please contact the developer.")
                    }
                    400 -> {
                        //Bad request but in this API that means (wrong password)
                        return MoviesException(e, "Invalid password or the entered user doesn't exist.")
                    }
                }
            }
            is UnknownHostException->{
                return MoviesException(e,"Unable to reach the server")
            }
        }
        return MoviesException(e, "Unexpected Error, please contact support.")
    }


    fun getApiKey() : String{
        return "157dfc341b3c40a79aca5616d49a0429"
    }
}