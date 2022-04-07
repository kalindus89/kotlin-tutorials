package com.kotlin.tutorialone.mvvm_full_tutorial.ui.auth

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.kotlin.tutorialone.mvvm_full_tutorial.data.db.entities.UserEntity
import com.kotlin.tutorialone.mvvm_full_tutorial.data.repository.UserRepository
import com.kotlin.tutorialone.mvvm_full_tutorial.utils.ApiExceptionss
import com.kotlin.tutorialone.mvvm_full_tutorial.utils.Coroutiness
import com.kotlin.tutorialone.mvvm_full_tutorial.utils.NoInternetException

class AuthViewModel  constructor(private val repository: UserRepository) : ViewModel() {

    suspend fun userLogin(email:String, password:String)=repository.userLogin(email,password)

    fun getLoggedInUser()=repository.getUser()


    suspend fun saveLoggedInUser(user:UserEntity)=repository.saveUser(user)



}
