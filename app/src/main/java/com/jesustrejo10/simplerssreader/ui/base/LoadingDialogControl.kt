package com.jesustrejo10.simplerssreader.ui.base

import androidx.fragment.app.FragmentManager

interface LoadingDialogControl {

    fun dismissDialogFragment()
    fun showDialogFragment(fragmentManager: FragmentManager)

}