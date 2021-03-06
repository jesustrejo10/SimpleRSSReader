package com.jesustrejo10.simplerssreader.model.data.response

import com.google.gson.annotations.SerializedName

data class AuthenticationResponse(
    @SerializedName("access_token")
    val authorizationToken : String?,

    @SerializedName("user_id")
    val userId : String?
)