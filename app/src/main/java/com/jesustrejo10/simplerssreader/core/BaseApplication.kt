package com.jesustrejo10.simplerssreader.core

import android.app.Application
import com.facebook.stetho.Stetho
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApplication  : Application(){

    override fun onCreate() {
        super.onCreate()
        initStetho()

    }

    private fun initStetho() {
        Stetho.initializeWithDefaults(this)
    }

}