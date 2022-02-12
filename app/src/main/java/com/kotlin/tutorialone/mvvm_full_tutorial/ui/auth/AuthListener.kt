package com.kotlin.tutorialone.mvvm_full_tutorial.ui.auth

import androidx.lifecycle.LiveData
import com.kotlin.tutorialone.mvvm_full_tutorial.data.db.entities.UserEntity
import com.kotlin.tutorialone.mvvm_full_tutorial.data.network.response.AuthResponseModel

interface AuthListener {

    fun onStarted() // calling api
    fun onSuccess(loginResponse: UserEntity) // api retrieved
    fun onFailure(message:String)
}