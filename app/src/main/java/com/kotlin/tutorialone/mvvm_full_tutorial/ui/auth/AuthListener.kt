package com.kotlin.tutorialone.mvvm_full_tutorial.ui.auth

interface AuthListener {

    fun onStarted() // calling api
    fun onSuccess() // api retrieved
    fun onFailure(message:String)
}