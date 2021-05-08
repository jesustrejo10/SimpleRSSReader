package com.jesustrejo10.simplerssreader.ui.feed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jesustrejo10.simplerssreader.model.usecases.GetArticlesForMyFeedUseCase
import com.jesustrejo10.simplerssreader.model.usecases.LoginUseCase
import com.jesustrejo10.simplerssreader.model.usecases.SignUpUserUseCase
import com.jesustrejo10.simplerssreader.model.usecases.SubscribeToFeedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedSetupViewModel  @Inject constructor(
    private val subscribeToFeedUseCase: SubscribeToFeedUseCase,
    private val getArticlesFromMyFeed : GetArticlesForMyFeedUseCase
): ViewModel() {




    fun test(){
        viewModelScope.launch(Dispatchers.IO) {
            subscribeToFeedUseCase.invoke("")
            getArticlesFromMyFeed.invoke("")
        }
    }
}