package com.kotlin.tutorialone.mvvm_full_tutorial.data.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface MyApi {

    @FormUrlEncoded
    @POST("login.php")
    fun userLogin(@Field("email") email: String, @Field("password") password: String): Call<ResponseBody>

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