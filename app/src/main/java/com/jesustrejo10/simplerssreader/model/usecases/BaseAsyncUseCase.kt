package com.jesustrejo10.simplerssreader.model.usecases


abstract class BaseAsyncUseCase<T,F>() {
    /**
     * Async use cases might need to return a response to layer above, so doing this it will be available.
     */
    abstract suspend fun invoke(entry : T) : F

}