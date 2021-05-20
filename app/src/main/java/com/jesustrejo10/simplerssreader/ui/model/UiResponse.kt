package com.jesustrejo10.simplerssreader.ui.model

data class UiResponse <T> (
    val status : OperationStatus,
    val exception : Exception?,
    val message: String,
    val value : T?
){

    companion object {
        fun <T> success(value : T) : UiResponse<T>{
            return UiResponse(OperationStatus.SUCCESS,null,"",value)
        }

        fun <T> success(value : T, message : String) : UiResponse<T>{
            return UiResponse(OperationStatus.SUCCESS,null,message,value)
        }

        fun <T> error(exception : Exception) : UiResponse<T>{
            return UiResponse(OperationStatus.ERROR,exception,
                exception.message ?: "Unexpected Error, please try again",null)
        }

        fun <T> error(message : String) : UiResponse<T>{
            return UiResponse(OperationStatus.ERROR,null,message,null)
        }


        fun <T> error() : UiResponse<T>{
            return UiResponse(OperationStatus.ERROR,null,"Unexpected Error, try again",null)
        }

        fun <T> loading(): UiResponse<T> {
            return UiResponse(OperationStatus.IN_PROGRESS,null,"Unexpected Error, try again",null)
        }

    }
}