package com.kotlin.tutorialone.mvvm_retrofit.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kotlin.tutorialone.mvvm_retrofit.repository.MoviesRepository

class MoviesViewModelFactory(private val repository: MoviesRepository):ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieListViewModel(repository) as T
    }
}