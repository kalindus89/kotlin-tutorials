package com.kotlin.tutorialone.mvvm_retrofit

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MovieApi {

    /*
    Suspend function is a function that could be started, paused, and resume.
    One of the most important points to remember about the suspend functions is
    that they are only allowed to be called from a coroutine or another suspend function.*/

    @GET("Avengers.json")
    suspend fun getMovies():Response<List<MovieResponses>>

    companion object{
        operator fun invoke():MovieApi{

            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://gist.githubusercontent.com/skydoves/933a70b21d7c96e8a8fdbe31ca72dada/raw/454f107f2c5f32c13823f7a6fd5031900f280d7c/")
                .build()
                .create(MovieApi::class.java)
        }
    }

}