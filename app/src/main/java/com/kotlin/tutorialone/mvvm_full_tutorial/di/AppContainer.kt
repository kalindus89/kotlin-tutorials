package com.kotlin.tutorialone.mvvm_full_tutorial.di

import android.content.Context
import com.kotlin.tutorialone.mvvm_full_tutorial.data.db.AppDatabase
import com.kotlin.tutorialone.mvvm_full_tutorial.data.network.MyApi
import com.kotlin.tutorialone.mvvm_full_tutorial.data.network.NetworkConnectorInterceptor
import com.kotlin.tutorialone.mvvm_full_tutorial.data.repository.UserRepository
import com.kotlin.tutorialone.mvvm_full_tutorial.ui.auth.AuthViewModelFactory

class AppContainer (context:Context){

    private val networkConnectorInterceptor = NetworkConnectorInterceptor(context)
    private val api = MyApi(networkConnectorInterceptor)
    private val db = AppDatabase(context)
    private val repository = UserRepository(api, db)
    private val factory = AuthViewModelFactory(repository)
}