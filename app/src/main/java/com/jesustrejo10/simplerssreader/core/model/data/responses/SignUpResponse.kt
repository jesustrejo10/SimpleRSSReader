package com.jesustrejo10.simplerssreader.core.model.data.responses

import com.google.gson.annotations.SerializedName

data class SignUpResponse(
    @SerializedName("auth_token")
    val authorizationToken : String?
)