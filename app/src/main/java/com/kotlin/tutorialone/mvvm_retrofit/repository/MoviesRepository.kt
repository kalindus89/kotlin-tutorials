package com.kotlin.tutorialone.mvvm_retrofit.repository

import com.kotlin.tutorialone.mvvm_retrofit.MovieApi
import com.kotlin.tutorialone.mvvm_retrofit.SafeApiRequest

class MoviesRepository (private val api: MovieApi): SafeApiRequest()

{
    suspend fun  getMovies()=apiRequest { api.getMovies() }
    suspend fun  getDisneyMovies()=apiRequest { api.getDisneyMovies() }

}