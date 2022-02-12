package com.kotlin.tutorialone.mvvm_full_tutorial.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.kotlin.tutorialone.R
import com.kotlin.tutorialone.databinding.MvvmLoginActivityBinding
import com.kotlin.tutorialone.mvvm_full_tutorial.utils.showToast

class MvvmLoginActivity : AppCompatActivity(),AuthListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.mvvm_login_activity) // use binding

        val binding:MvvmLoginActivityBinding= DataBindingUtil.setContentView(this,R.layout.mvvm_login_activity)
      //  MvvmLoginActivityBinding xml name

       val authViewModel= ViewModelProvider(this).get(AuthViewModel::class.java)

        binding.authViewModel=authViewModel


        authViewModel.listener=this


    }

    override fun onStarted() {
       showToast("Login started")
    }

    override fun onSuccess() {
        showToast("Login success")

    }

    override fun onFailure(message: String) {
        showToast("Login failure $message")
    }
}