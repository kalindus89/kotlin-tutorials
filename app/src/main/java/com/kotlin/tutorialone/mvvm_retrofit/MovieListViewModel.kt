package com.kotlin.tutorialone.mvvm_retrofit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job

class MovieListViewModel(private val repository: MoviesRepository) : ViewModel() {

    private val movies=MutableLiveData<List<ModelResponse>>()
    private lateinit var work:Job

    val moviesLive :LiveData<List<ModelResponse>>
    get() = movies

     fun getMovies(){

        work =Coroutines.ioThenMain(
            {repository.getMovies()}
            ,{
                movies.value=it
            })

    }

    override fun onCleared() {
        super.onCleared()

        if(::work.isInitialized)work.cancel()
    }

}