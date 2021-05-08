package com.jesustrejo10.simplerssreader.ui.base

import androidx.appcompat.app.AppCompatActivity
import java.lang.Exception

abstract class BaseActivity : AppCompatActivity() {

    private val loadingDialogFragment : LoadingDialogControl =
        LoadingDialogFragment()

    open fun displayLoading(){
        try{
            loadingDialogFragment.dismissDialogFragment()
            loadingDialogFragment.showDialogFragment(supportFragmentManager)
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    open fun dismissLoading(){
        try{
            loadingDialogFragment.dismissDialogFragment()
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    abstract fun manageViewComponents()

    abstract fun manageObservers()
}