package com.jesustrejo10.simplerssreader.data.remote.datasource

import com.jesustrejo10.simplerssreader.data.remote.EndPoints
import com.jesustrejo10.simplerssreader.data.remote.repository.RssRepository
import com.jesustrejo10.simplerssreader.model.data.request.SubscribeToFeedRequest
import com.jesustrejo10.simplerssreader.model.data.response.RssArticle
import retrofit2.await
import java.lang.Exception
import javax.inject.Inject

class RssRemoteDataSource @Inject constructor(
    private val apiDefinitionService: EndPoints
) :
    BaseDataSource(), RssRepository {

    override suspend fun subscribe(): Any {
        try{
            return apiDefinitionService.subscribeToRss(SubscribeToFeedRequest()).await()
        }catch (e : Exception){
            throw manageError(e)
        }
    }

    override suspend fun getArticles(): List<RssArticle>? {
        try{
            return apiDefinitionService.getArticles().await()
        }catch (e : Exception){
            throw manageError(e)
        }
    }
}