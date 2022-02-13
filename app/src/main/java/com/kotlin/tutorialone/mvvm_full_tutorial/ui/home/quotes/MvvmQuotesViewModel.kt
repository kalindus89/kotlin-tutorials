package com.kotlin.tutorialone.mvvm_full_tutorial.ui.home.quotes

import androidx.lifecycle.ViewModel
import com.kotlin.tutorialone.mvvm_full_tutorial.data.repository.QuotesRepository
import com.kotlin.tutorialone.mvvm_full_tutorial.utils.lazyDeferred

class MvvmQuotesViewModel(repository: QuotesRepository) : ViewModel() {

    val quotes by lazyDeferred {
        repository.getQuotes()
    }

}