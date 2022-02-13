package com.kotlin.tutorialone.mvvm_full_tutorial.ui.home.quotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kotlin.tutorialone.mvvm_full_tutorial.data.repository.QuotesRepository
import com.kotlin.tutorialone.mvvm_full_tutorial.data.repository.UserRepository
import com.kotlin.tutorialone.mvvm_retrofit.view_model.MovieListViewModel

class QuotesViewModelFactory (private val repository: QuotesRepository): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MvvmQuotesViewModel(repository) as T
    }
}