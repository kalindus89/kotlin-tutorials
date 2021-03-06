package com.kotlin.tutorialone.mvvm_full_tutorial.data.network

import com.kotlin.tutorialone.mvvm_full_tutorial.data.network.response.AuthResponseModel
import com.kotlin.tutorialone.mvvm_full_tutorial.data.network.response.QuotesResponseModel
import com.kotlin.tutorialone.mvvm_full_tutorial.data.network.response.QuotesResponseModel22
import okhttp3.OkHttpClient
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



    @POST("quotes.php")
    suspend fun getQuotes():Response<QuotesResponseModel>

    @GET("quotes.php")
   suspend fun getQuotesForCoroutine():Response<QuotesResponseModel>

    @GET("new_quotes.php")
   suspend fun getQuotesForCoroutineSecond():Response<QuotesResponseModel22>

     @GET("quotes.php")
     fun getQuotesForCoroutineNormalWay():Call<QuotesResponseModel>


    companion object{
        operator fun invoke(networkConnectorInterceptor: NetworkConnectorInterceptor
        ): MyApi {  //invoke()  can be called on any instances of the class without a method name!

            val okkHttpClient =OkHttpClient.Builder().addInterceptor(networkConnectorInterceptor).build()

            return Retrofit.Builder()
                .client(okkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://testapi.nixetechnology.com/")
                .build()
                .create(MyApi::class.java)
        }
    }

}