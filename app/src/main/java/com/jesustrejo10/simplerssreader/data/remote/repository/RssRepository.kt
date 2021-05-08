package com.jesustrejo10.simplerssreader.data.remote.repository

import com.jesustrejo10.simplerssreader.model.data.response.RssArticle

interface RssRepository {

    suspend fun subscribe() : Any

    suspend fun getArticles() : List<RssArticle>?

}