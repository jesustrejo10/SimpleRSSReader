package com.jesustrejo10.simplerssreader.ui.feed

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.jesustrejo10.simplerssreader.R
import com.jesustrejo10.simplerssreader.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeedSetupActivity : BaseActivity() {

    private lateinit var viewModel: FeedSetupViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.authenticate_activity)
        viewModel = ViewModelProvider(this).get(FeedSetupViewModel::class.java)
        manageViewComponents()
        manageObservers()

        viewModel.test()
    }
    override fun manageViewComponents() {
    }

    override fun manageObservers() {
    }
}