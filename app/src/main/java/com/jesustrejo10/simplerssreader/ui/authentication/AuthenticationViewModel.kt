package com.jesustrejo10.simplerssreader.ui.authentication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jesustrejo10.simplerssreader.data.local.StaticValues
import com.jesustrejo10.simplerssreader.model.data.request.AuthenticationRequest
import com.jesustrejo10.simplerssreader.model.data.response.AuthenticationResponse
import com.jesustrejo10.simplerssreader.model.usecases.LoginUseCase
import com.jesustrejo10.simplerssreader.model.usecases.SignUpUserUseCase
import com.jesustrejo10.simplerssreader.ui.model.UiResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthenticationViewModel  @Inject constructor(
    private val signUpUseCase: SignUpUserUseCase,
    private val loginUseCase : LoginUseCase
) : ViewModel(){

    private val loginMutableLiveData = MutableLiveData<UiResponse<AuthenticationResponse?>>()
    val loginLiveData: LiveData<UiResponse<AuthenticationResponse?>> = loginMutableLiveData
    private val signUpMutableLiveData = MutableLiveData<UiResponse<AuthenticationResponse?>>()
    val signUpLiveData: LiveData<UiResponse<AuthenticationResponse?>> = signUpMutableLiveData

    fun signUp(userName: String, pass: String) {
        viewModelScope.launch(Dispatchers.IO) {
            signUpMutableLiveData.postValue(UiResponse.loading())
            val loginResult =signUpUseCase.invoke(AuthenticationRequest(userName,pass))
            if(loginResult.success){
                StaticValues.AUTHENTICATION = loginResult.value?.authorizationToken ?: ""
                signUpMutableLiveData.postValue(UiResponse.success(loginResult.value))
            }else{
                signUpMutableLiveData.postValue(UiResponse.error(loginResult.errorMessage))
            }
        }
    }

    fun login(username: String, pass: String) {
        viewModelScope.launch(Dispatchers.IO) {
            loginMutableLiveData.postValue(UiResponse.loading())
            val loginResult =loginUseCase.invoke(AuthenticationRequest(username,pass))
            if(loginResult.success){
                StaticValues.AUTHENTICATION = loginResult.value?.authorizationToken ?: ""
                loginMutableLiveData.postValue(UiResponse.success(loginResult.value))
            }else{
                loginMutableLiveData.postValue(UiResponse.error(loginResult.errorMessage))
            }
        }
    }
}