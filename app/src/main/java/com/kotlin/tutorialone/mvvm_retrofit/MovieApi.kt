package com.kotlin.tutorialone.mvvm_retrofit

import com.kotlin.tutorialone.mvvm_retrofit.models.ModelResponse
import com.kotlin.tutorialone.mvvm_retrofit.models.ModelResponseDisney
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MovieApi {

    /*
    Suspend function is a function that could be started, paused, and resume.
    One of the most important points to remember about the suspend functions is
    that they are only allowed to be called from a coroutine or another suspend function.*/


    @GET("933a70b21d7c96e8a8fdbe31ca72dada/raw")
    suspend fun getMovies():Response<List<ModelResponse>>


    @GET("aa3bbbf495b0fa91db8a9e89f34e4873/raw")
    suspend fun getDisneyMovies():Response<List<ModelResponseDisney>>

    companion object{
        operator fun invoke():MovieApi{

            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://gist.githubusercontent.com/skydoves/")
               // .baseUrl("http://mobileapi.efserver.net/mobile_api_test/")
                .build()
                .create(MovieApi::class.java)
        }
    }

}