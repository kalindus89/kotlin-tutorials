package com.kotlin.tutorialone.mvvm_full_tutorial.coroutine_sample

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kotlin.tutorialone.mvvm_full_tutorial.data.repository.QuotesRepository
import com.kotlin.tutorialone.mvvm_full_tutorial.data.repository.UserRepository
import com.kotlin.tutorialone.mvvm_retrofit.view_model.MovieListViewModel

class CoroutineViewModelFactory (private val context: Context): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CoroutineViewModel(context) as T
    }
}