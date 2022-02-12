package com.kotlin.tutorialone.mvvm_full_tutorial.ui.auth

import androidx.lifecycle.LiveData

interface AuthListener {

    fun onStarted() // calling api
    fun onSuccess(loginResponse: LiveData<String>) // api retrieved
    fun onFailure(message:String)
}