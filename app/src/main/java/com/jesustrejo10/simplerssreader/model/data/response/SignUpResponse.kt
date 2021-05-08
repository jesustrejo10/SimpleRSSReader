package com.jesustrejo10.simplerssreader.model.data.response

import com.google.gson.annotations.SerializedName

data class SignUpResponse(
    @SerializedName("auth_token")
    val authorizationToken : String?
)