package com.kotlin.tutorialone.mvvm_full_tutorial.di

import com.kotlin.tutorialone.mvvm_full_tutorial.data.repository.UserRepository
import com.kotlin.tutorialone.mvvm_full_tutorial.ui.auth.AuthViewModelFactory

class AuthContainer(userRepository: UserRepository) {

    val authViewModelFactory =AuthViewModelFactory(userRepository)
}