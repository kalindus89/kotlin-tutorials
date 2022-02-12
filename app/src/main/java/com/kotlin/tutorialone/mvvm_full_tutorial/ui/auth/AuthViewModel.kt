package com.kotlin.tutorialone.mvvm_full_tutorial.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel

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
            listener?.onSuccess()
        }

    }

}
