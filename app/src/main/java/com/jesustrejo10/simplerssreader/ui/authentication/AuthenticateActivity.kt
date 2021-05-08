package com.jesustrejo10.simplerssreader.ui.authentication

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jesustrejo10.simplerssreader.R
import com.jesustrejo10.simplerssreader.model.data.response.AuthenticationResponse
import com.jesustrejo10.simplerssreader.ui.base.BaseActivity
import com.jesustrejo10.simplerssreader.ui.feed.FeedSetupActivity
import com.jesustrejo10.simplerssreader.ui.model.OperationStatus
import com.jesustrejo10.simplerssreader.ui.model.UiResponse
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.authenticate_activity.*

@AndroidEntryPoint
class AuthenticateActivity : BaseActivity() {

    private lateinit var viewModel: AuthenticationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.authenticate_activity)
        viewModel = ViewModelProvider(this).get(AuthenticationViewModel::class.java)
        manageViewComponents()
        manageObservers()
    }

    override fun manageObservers() {

        viewModel.loginLiveData.observe(this, Observer {
            manageLoginResponse(it)
        })

        viewModel.signUpLiveData.observe(this, Observer {
            manageSignUpResponse(it)
        })
    }

    private fun manageSignUpResponse(it: UiResponse<AuthenticationResponse?>?) {
        if(it == null)
            return

        when(it.status){
            OperationStatus.SUCCESS -> {
                goToNextScreen()
                dismissLoading()
            }
            OperationStatus.ERROR -> {
                displayError(it.message)
                dismissLoading()
            }
            OperationStatus.IN_PROGRESS -> {
                displayLoading()
            }
        }
    }

    private fun displayError(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }

    private fun manageLoginResponse(it: UiResponse<AuthenticationResponse?>) {
        when(it.status){
            OperationStatus.SUCCESS -> {
                goToNextScreen()
                dismissLoading()
            }
            OperationStatus.ERROR -> {
                checkIfWrongPassword()
                dismissLoading()
            }
            OperationStatus.IN_PROGRESS -> {
                displayLoading()
            }
        }
    }

    private fun checkIfWrongPassword() {
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setTitle("User not found, would you like to create it?")
        dialogBuilder.setMessage("Current API, doesn't differentiate between wrong password or wrong user. So, you could try to create a new user with the same information" +
                "but if the user already exists and the password entered is wrong. It won't allow you to pass.")
        dialogBuilder.setPositiveButton("Create User"
        ) { dialogControl: DialogInterface, _: Int ->
            createUser()
            dialogControl.dismiss()
        }
        dialogBuilder.setNegativeButton("Update password") { dialogInterface: DialogInterface, i: Int ->
            dialogInterface.dismiss()
        }
        dialogBuilder.show()
    }

    private fun createUser() {
        handleOperationRequest(true)
    }

    private fun goToNextScreen() {
        startActivity(Intent(this, FeedSetupActivity::class.java))
        finish()
    }

    override fun manageViewComponents() {
        login.setOnClickListener{
            handleOperationRequest()
        }
    }

    private fun handleOperationRequest(isAutomatic : Boolean = false) {
        val userName =username.text.toString()
        if(userName.isEmpty()){
            username.error = getString(R.string.empty_field)
            return
        }

        val pass =password.text.toString()
        if(pass.isEmpty()){
            password.error = getString(R.string.empty_field)
            return
        }

        if(isAutomatic)
            callSignUp(userName,pass)
        else
            callLogin(userName,pass)
    }

    private fun callSignUp(userName: String, pass: String) {
        viewModel.signUp(userName,pass)
    }

    private fun callLogin(userName: String, pass: String) {
        viewModel.login(userName,pass)
    }



}