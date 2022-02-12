package com.kotlin.tutorialone.mvvm_full_tutorial.data.network

import com.kotlin.tutorialone.mvvm_full_tutorial.data.network.response.AuthResponseModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface MyApi {

   // @FormUrlEncoded
    @POST("login.php")
   suspend fun userLogin(
        @Query("email") email: String,
        @Query("password") password: String)
   :Response<AuthResponseModel>
//suspend is the center of coroutine. it simplified the function resume and pause

    companion object{
        operator fun invoke(): MyApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://testapi.nixetechnology.com/")
                .build()
                .create(MyApi::class.java)
        }
    }

}