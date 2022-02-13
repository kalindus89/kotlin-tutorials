package com.kotlin.tutorialone.mvvm_full_tutorial.ui.home.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kotlin.tutorialone.mvvm_full_tutorial.data.repository.UserRepository
import com.kotlin.tutorialone.mvvm_retrofit.view_model.MovieListViewModel

class ProfileViewModelFactory (private val repository: UserRepository): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MvvmProfileViewModel(repository) as T
    }
}