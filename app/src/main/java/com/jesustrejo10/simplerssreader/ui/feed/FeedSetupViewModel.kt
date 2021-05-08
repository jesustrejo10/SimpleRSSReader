package com.jesustrejo10.simplerssreader.ui.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jesustrejo10.simplerssreader.model.data.response.AuthenticationResponse
import com.jesustrejo10.simplerssreader.model.data.response.RssArticle
import com.jesustrejo10.simplerssreader.model.usecases.GetArticlesForMyFeedUseCase
import com.jesustrejo10.simplerssreader.model.usecases.SubscribeToFeedUseCase
import com.jesustrejo10.simplerssreader.ui.model.UiResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedSetupViewModel  @Inject constructor(
    private val subscribeToFeedUseCase: SubscribeToFeedUseCase,
    private val getArticlesFromMyFeed : GetArticlesForMyFeedUseCase
): ViewModel() {

    private val getArticlesMutableLiveData = MutableLiveData<UiResponse<List<RssArticle>?>>()
    val getArticlesLiveData: LiveData<UiResponse<List<RssArticle>?>> = getArticlesMutableLiveData



    fun test(){
        viewModelScope.launch(Dispatchers.IO) {
            getArticlesMutableLiveData.postValue(UiResponse.loading())
            subscribeToFeedUseCase.invoke("")
            val articles = getArticlesFromMyFeed.invoke("")
            if(articles.success){
                getArticlesMutableLiveData.postValue(UiResponse.success(articles.value))
            }else{
                println("")
            }
        }
    }
}