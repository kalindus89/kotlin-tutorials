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
import androidx.lifecycle.lifecycleScope
import com.kotlin.tutorialone.R
import com.kotlin.tutorialone.databinding.MvvmLoginActivityBinding
import com.kotlin.tutorialone.mvvm_full_tutorial.MVVMApplication
import com.kotlin.tutorialone.mvvm_full_tutorial.data.db.AppDatabase
import com.kotlin.tutorialone.mvvm_full_tutorial.data.db.entities.UserEntity
import com.kotlin.tutorialone.mvvm_full_tutorial.data.network.MyApi
import com.kotlin.tutorialone.mvvm_full_tutorial.data.network.NetworkConnectorInterceptor
import com.kotlin.tutorialone.mvvm_full_tutorial.data.network.response.AuthResponseModel
import com.kotlin.tutorialone.mvvm_full_tutorial.data.repository.UserRepository
import com.kotlin.tutorialone.mvvm_full_tutorial.di.AppContainer
import com.kotlin.tutorialone.mvvm_full_tutorial.di.AuthContainer
import com.kotlin.tutorialone.mvvm_full_tutorial.ui.home.MvvmHomeActivity
import com.kotlin.tutorialone.mvvm_full_tutorial.utils.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MvvmLoginActivity : AppCompatActivity() {

    private lateinit var progressbar: ProgressBar
    private lateinit var binding: MvvmLoginActivityBinding
    var authViewModel: AuthViewModel ?= null

    lateinit var appContainer: AppContainer // initialize in the Application Class

    override fun onDestroy() {
        super.onDestroy()

        appContainer.authContainer=null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.mvvm_login_activity) // use binding


       /* val networkConnectorInterceptor = NetworkConnectorInterceptor(this)
        val api = MyApi(networkConnectorInterceptor)
        val db = AppDatabase(this)
        val repository = UserRepository(api, db)
        val factory = AuthViewModelFactory(repository)*/

        appContainer=(application as MVVMApplication).appContainer
        appContainer.authContainer= AuthContainer(appContainer.repository)

        binding = DataBindingUtil.setContentView(this, R.layout.mvvm_login_activity)
        //  MvvmLoginActivityBinding xml name
        authViewModel = ViewModelProvider(this, appContainer.authContainer!!.authViewModelFactory).get(AuthViewModel::class.java)

        progressbar = findViewById<ProgressBar>(R.id.progress_bar);


        authViewModel!!.getLoggedInUser().observe(this, Observer { user ->
           /* if (user != null) {

                Intent(this, MvvmHomeActivity::class.java).also {
                    it.flags =
                        Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK // finish this activity
                    startActivity(it)
                }
            }*/
        })

        binding.buttonSignIn.setOnClickListener {
            loginUser()
        }


    }

    private fun loginUser() {
        val email = binding.editTextEmail.text.toString().trim()
        val password = binding.editTextPassword.text.toString().trim()


        lifecycleScope.launch {

            if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
                showToast("Null Or Empty")
            }

            else {
                try {
                    val loginResponse = authViewModel?.userLogin(email!!, password!!)


                    if (loginResponse != null) {
                        if(loginResponse.isSuccessful==false){
                            binding.rootLayout.showSnackbar("Error ${loginResponse.message}")
                        }else{
                            loginResponse.user?.let { // run only if not null

                                if (loginResponse?.isSuccessful == true) {
                                    binding.rootLayout.showSnackbar("User name: " + loginResponse.user.name_user
                                            + ". user email: " + loginResponse.user.email_user + " ")
                                    authViewModel?.saveLoggedInUser(it)

                                }else{
                                    binding.rootLayout.showSnackbar("no user")
                                }
                            }
                        }
                    }

                } catch (e: ApiExceptionss) {
                    e.printStackTrace()

                } catch (e: NoInternetException) {
                    e.printStackTrace()
                }

            }
        }
    }

}