package com.kotlin.tutorialone.mvvm_full_tutorial.ui.home.profile

import androidx.lifecycle.ViewModel
import com.kotlin.tutorialone.mvvm_full_tutorial.data.repository.UserRepository

class MvvmProfileViewModel (repository: UserRepository): ViewModel() {

    val user=repository.getUser()

}