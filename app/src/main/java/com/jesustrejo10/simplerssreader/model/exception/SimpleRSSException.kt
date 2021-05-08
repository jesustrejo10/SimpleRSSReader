package com.jesustrejo10.simplerssreader.model.exception

import java.lang.Exception

class SimpleRSSException(error : Exception, val messageToView : String ) : Exception(error) {


}