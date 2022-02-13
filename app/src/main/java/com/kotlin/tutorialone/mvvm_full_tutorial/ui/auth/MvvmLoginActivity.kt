package com.kotlin.tutorialone.mvvm_full_tutorial.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kotlin.tutorialone.R
import com.kotlin.tutorialone.databinding.MvvmLoginActivityBinding
import com.kotlin.tutorialone.mvvm_full_tutorial.data.db.AppDatabase
import com.kotlin.tutorialone.mvvm_full_tutorial.data.db.entities.UserEntity
import com.kotlin.tutorialone.mvvm_full_tutorial.data.network.MyApi
import com.kotlin.tutorialone.mvvm_full_tutorial.data.network.NetworkConnectorInterceptor
import com.kotlin.tutorialone.mvvm_full_tutorial.data.network.response.AuthResponseModel
import com.kotlin.tutorialone.mvvm_full_tutorial.data.repository.UserRepository
import com.kotlin.tutorialone.mvvm_full_tutorial.ui.home.MvvmHomeActivity
import com.kotlin.tutorialone.mvvm_full_tutorial.utils.showSnackbar
import com.kotlin.tutorialone.mvvm_full_tutorial.utils.showToast
import kotlinx.coroutines.Job

class MvvmLoginActivity : AppCompatActivity(),AuthListener {

    private lateinit var  progressbar:ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.mvvm_login_activity) // use binding


        val networkConnectorInterceptor=NetworkConnectorInterceptor(this)
        val api =MyApi(networkConnectorInterceptor)
        val db =AppDatabase(this)
        val repository =UserRepository(api,db)
        val factory=AuthViewModelFactory(repository)


        val binding:MvvmLoginActivityBinding= DataBindingUtil.setContentView(this,R.layout.mvvm_login_activity)
      //  MvvmLoginActivityBinding xml name
         progressbar =findViewById<ProgressBar>(R.id.progress_bar);
       val authViewModel= ViewModelProvider(this,factory).get(AuthViewModel::class.java)
        binding.authViewModel=authViewModel

        authViewModel.listener=this

        authViewModel.getLoggedInUser().observe(this, Observer { user->
            if(user !=null){

                Intent(this,MvvmHomeActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK // finish this activity
                    startActivity(it)
                }
            }
        })


    }

    override fun onStarted() {

        progressbar.visibility=View.VISIBLE
    }

    override fun onSuccess(loginResponse:UserEntity) {

        progressbar.visibility=View.GONE
        val root_layout=findViewById<CoordinatorLayout>(R.id.root_layout)
        root_layout.showSnackbar( "User name: "+loginResponse.name_user+". user email: "+loginResponse.email_user+" ")

    }

    override fun onFailure(message: String) {
        progressbar.visibility=View.GONE
        showToast(" $message")
    }
}