package com.jesustrejo10.simplerssreader.model.usecases

class UseCaseResult <T>(
    val success : Boolean = true,
    val value : T?, 
    val errorMessage : String ? = "Unexpected error, please try again or contact support.") {
    
    companion object{
        
        fun <T> success( value : T) = UseCaseResult(value = value)

        fun <T> error ( message : String) = UseCaseResult(false,null as T?,message)

    }
}