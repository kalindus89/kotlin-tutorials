package com.kotlin.tutorialone.mvvm_retrofit

class MoviesRepository (private val api:MovieApi):SafeApiRequest()

{
    suspend fun  getMovies()=apiRequest { api.getMovies() }

}