package com.kotlin.tutorialone.mvvm_full_tutorial.di

import android.content.Context
import com.kotlin.tutorialone.mvvm_full_tutorial.data.db.AppDatabase
import com.kotlin.tutorialone.mvvm_full_tutorial.data.network.MyApi
import com.kotlin.tutorialone.mvvm_full_tutorial.data.network.NetworkConnectorInterceptor
import com.kotlin.tutorialone.mvvm_full_tutorial.data.repository.UserRepository
import com.kotlin.tutorialone.mvvm_full_tutorial.ui.auth.AuthViewModelFactory

class AppContainer (context:Context){

    //for dependency injection

   /* private val networkConnectorInterceptor = NetworkConnectorInterceptor(context)
    private val api = MyApi(networkConnectorInterceptor)
    private val db = AppDatabase(context)
     val repository = UserRepository(api, db)
     var authContainer:AuthContainer ?= null*/

    fun test(){
    }
}