package com.kotlin.tutorialone.mvvm_full_tutorial.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kotlin.tutorialone.kolin_basic_tutorials.oop_kotlin.User
import com.kotlin.tutorialone.mvvm_full_tutorial.data.db.AppDatabase
import com.kotlin.tutorialone.mvvm_full_tutorial.data.db.entities.UserEntity
import com.kotlin.tutorialone.mvvm_full_tutorial.data.network.MyApi
import com.kotlin.tutorialone.mvvm_full_tutorial.data.network.SafeApiRequest
import com.kotlin.tutorialone.mvvm_full_tutorial.data.network.response.AuthResponseModel
import com.kotlin.tutorialone.mvvm_retrofit.MovieApi
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository(
    private val myApi:MyApi,
    private val db:AppDatabase):SafeApiRequest() {

   suspend fun userLogin(email:String, password:String):AuthResponseModel{

       return apiRequest { myApi.userLogin(email,password) }

    }

    suspend fun saveUser(user:UserEntity)=db.getUserDao().insert_data(user)

    fun getUser()=db.getUserDao().getUser()
}