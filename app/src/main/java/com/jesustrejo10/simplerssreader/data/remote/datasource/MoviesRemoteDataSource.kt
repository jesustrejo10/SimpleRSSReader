package com.jesustrejo10.simplerssreader.data.remote.datasource

import com.jesustrejo10.simplerssreader.data.remote.EndPoints
import com.jesustrejo10.simplerssreader.data.remote.repository.MoviesRepository
import com.jesustrejo10.simplerssreader.model.data.response.GetMoviesResponse
import retrofit2.await
import java.lang.Exception
import javax.inject.Inject

class MoviesRemoteDataSource @Inject constructor(private val apiDefinitionService: EndPoints) :
    BaseDataSource(), MoviesRepository {


    override suspend fun getMovies(): GetMoviesResponse {
        try{
            return apiDefinitionService.getMovies(getApiKey()).await()
        }catch (e : Exception){
            e.printStackTrace()
            throw manageErrorFromMovies(e)
        }
    }

}