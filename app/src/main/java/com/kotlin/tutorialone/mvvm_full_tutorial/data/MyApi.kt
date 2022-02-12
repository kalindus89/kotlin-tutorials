package com.kotlin.tutorialone.mvvm_full_tutorial.data

import com.kotlin.tutorialone.mvvm_retrofit.MovieApi
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.POST

interface MyApi {

    @POST("login")
    fun userLogin(
        @Field("email") email:String,
        @Field("password") password:String
    ): Call<ResponseBody>

    companion object{
        operator fun invoke(): MovieApi {

            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://testapi.nixetechnology.com/")
                .build()
                .create(MovieApi::class.java)
        }
    }

}