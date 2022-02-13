package com.kotlin.tutorialone.mvvm_full_tutorial.ui.auth

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.kotlin.tutorialone.mvvm_full_tutorial.data.repository.UserRepository
import com.kotlin.tutorialone.mvvm_full_tutorial.utils.ApiExceptionss
import com.kotlin.tutorialone.mvvm_full_tutorial.utils.Coroutiness
import com.kotlin.tutorialone.mvvm_full_tutorial.utils.NoInternetException

class AuthViewModel(private val repository: UserRepository) : ViewModel() {
    //two way databinding

    var email:String ?=null
    var password:String ?=null

    var listener:AuthListener ?=null

    fun onLoginButtonClick(view: View){ // we need to pass view

        if(email.isNullOrEmpty() || password.isNullOrEmpty()){
            listener?.onFailure("Null Or Empty")
        }
        else{

            listener?.onStarted()

            Coroutiness.main{

                try {
                    val loginResponse = repository.userLogin(email!!, password!!)

                    loginResponse.user?.let { // run only if not null
                        listener?.onSuccess(loginResponse?.user!!)
                        if(loginResponse?.isSuccessful == true) {
                            repository.saveUser(it)
                        }
                        return@main //  listener?.onFailure("Error code: ${loginResponse.message!!}") will not run
                    }
                    listener?.onFailure("Error code: ${loginResponse.message!!}")

                }catch (e:ApiExceptionss){
                    listener?.onFailure("Error code: ${e.message!!}")

                }catch (e:NoInternetException){
                    listener?.onFailure("Error code: ${e.message!!}")
                }


            }
        }

    }

    fun getLoggedInUser()=repository.getUser()

}
