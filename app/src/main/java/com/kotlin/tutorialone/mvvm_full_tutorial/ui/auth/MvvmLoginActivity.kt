package com.kotlin.tutorialone.mvvm_full_tutorial.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kotlin.tutorialone.R
import com.kotlin.tutorialone.databinding.MvvmLoginActivityBinding
import com.kotlin.tutorialone.mvvm_full_tutorial.utils.showToast
import kotlinx.coroutines.Job

class MvvmLoginActivity : AppCompatActivity(),AuthListener {

    private lateinit var  progressbar:ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.mvvm_login_activity) // use binding

        val binding:MvvmLoginActivityBinding= DataBindingUtil.setContentView(this,R.layout.mvvm_login_activity)
      //  MvvmLoginActivityBinding xml name
         progressbar =findViewById<ProgressBar>(R.id.progress_bar);
       val authViewModel= ViewModelProvider(this).get(AuthViewModel::class.java)

        binding.authViewModel=authViewModel
        authViewModel.listener=this


    }

    override fun onStarted() {

        progressbar.visibility=View.VISIBLE
    }

    override fun onSuccess(loginResponse: LiveData<String>) {


        loginResponse.observe(this, Observer {

            progressbar.visibility=View.GONE
            showToast("api called")
        })

    }

    override fun onFailure(message: String) {
        showToast("Login failure $message")
    }
}