package com.jesustrejo10.simplerssreader.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.jesustrejo10.simplerssreader.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthenticateActivity : AppCompatActivity() {

    private lateinit var viewModel: AuthenticationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.authenticate_activity)
        viewModel = ViewModelProvider(this).get(AuthenticationViewModel::class.java)

        viewModel.test()
    }
}