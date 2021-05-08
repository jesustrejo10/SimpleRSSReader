package com.jesustrejo10.simplerssreader.model.usecases

import com.jesustrejo10.simplerssreader.data.remote.datasource.RssRemoteDataSource
import com.jesustrejo10.simplerssreader.model.data.response.RssArticle
import com.jesustrejo10.simplerssreader.model.exception.SimpleRSSException
import javax.inject.Inject

class GetArticlesForMyFeedUseCase @Inject constructor(private val rssRemoteDataSource: RssRemoteDataSource) :
    BaseAsyncUseCase<String, UseCaseResult<List<RssArticle>?>>(){
    /**
     * Async use cases might need to return a response to layer above, so doing this it will be available.
     */
    override suspend fun invoke(entry: String): UseCaseResult<List<RssArticle>?> {
        return try {
            UseCaseResult.success(rssRemoteDataSource.getArticles())
        }catch (e : SimpleRSSException){
            e.printStackTrace()
            UseCaseResult.error(e.messageToView)
        }
    }

}