package com.kotlin.tutorialone.mvvm_full_tutorial.ui.auth

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.kotlin.tutorialone.mvvm_full_tutorial.data.repository.UserRepository
import com.kotlin.tutorialone.mvvm_full_tutorial.utils.Coroutiness

class AuthViewModel : ViewModel() {
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

                val loginResponse=UserRepository().userLogin(email!!, password!!)

                if (loginResponse.isSuccessful) {
                 //   listener?.onFailure("code: ${loginResponse.body()?.isSuccessful.toString()}")
                    listener?.onSuccess(loginResponse.body()?.user!!)
                }else{
                    listener?.onFailure("Error code: ${loginResponse.code()}")
                }


            }
        }



    }

}
