package com.jesustrejo10.simplerssreader.model.exception

import java.lang.Exception

class MoviesException(e : Exception, val messageToView: String) : Exception(e) {
}