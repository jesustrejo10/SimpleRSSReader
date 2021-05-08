package com.jesustrejo10.simplerssreader.ui.feed

import com.jesustrejo10.simplerssreader.model.data.response.RssArticle

interface ArticleListContract {

    fun onArticleClick(article : RssArticle)
}