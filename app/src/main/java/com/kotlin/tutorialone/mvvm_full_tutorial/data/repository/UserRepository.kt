package com.kotlin.tutorialone.mvvm_full_tutorial.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kotlin.tutorialone.mvvm_full_tutorial.data.network.MyApi
import com.kotlin.tutorialone.mvvm_full_tutorial.data.network.response.AuthResponseModel
import com.kotlin.tutorialone.mvvm_retrofit.MovieApi
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository() {

   suspend fun userLogin(email:String, password:String):Response<AuthResponseModel>{

        return MyApi().userLogin(email,password)

    }
}