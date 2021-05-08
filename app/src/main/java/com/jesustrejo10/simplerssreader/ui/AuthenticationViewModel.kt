package com.jesustrejo10.simplerssreader.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jesustrejo10.simplerssreader.model.data.request.SignUpRequest
import com.jesustrejo10.simplerssreader.model.usecases.SignUpUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthenticationViewModel  @Inject constructor( val useCase: SignUpUserUseCase)
    : ViewModel(){




    fun test() {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.invoke(SignUpRequest("cacciaresi","cacciaresi"))
        }
    }
}