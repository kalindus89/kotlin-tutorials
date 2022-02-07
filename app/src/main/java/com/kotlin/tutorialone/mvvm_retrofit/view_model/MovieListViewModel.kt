package com.kotlin.tutorialone.mvvm_retrofit.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kotlin.tutorialone.mvvm_retrofit.Coroutines
import com.kotlin.tutorialone.mvvm_retrofit.repository.MoviesRepository
import com.kotlin.tutorialone.mvvm_retrofit.models.ModelResponse
import com.kotlin.tutorialone.mvvm_retrofit.models.ModelResponseDisney
import kotlinx.coroutines.Job

class MovieListViewModel(private val repository: MoviesRepository) : ViewModel() {

    private lateinit var work:Job

    //--------------------one Api--------------------------
    private val movies=MutableLiveData<List<ModelResponse>>()

    val moviesLive :LiveData<List<ModelResponse>>
    get() = movies

     fun getMovies(){

        work = Coroutines.ioThenMain(
            { repository.getMovies() }, {
                movies.value = it
            })

    }

    //--------------------another Api--------------------------
    private val moviesDisney=MutableLiveData<List<ModelResponseDisney>>()

    val moviesDisneyLive :LiveData<List<ModelResponseDisney>>
        get() = moviesDisney

    fun getDisneyMovies(){

        work = Coroutines.ioThenMain(
            { repository.getDisneyMovies() }, {
                moviesDisney.value = it
            })

    }


    override fun onCleared() {
        super.onCleared()

        if(::work.isInitialized)work.cancel()
    }

}