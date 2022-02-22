package com.kotlin.tutorialone.mvvm_full_tutorial.coroutine_sample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kotlin.tutorialone.mvvm_full_tutorial.data.db.entities.Quotes

class CoroutineViewModel: ViewModel() {

    val quotes:LiveData<List<Quotes>> = MutableLiveData()



}