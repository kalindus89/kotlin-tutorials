package com.kotlin.tutorialone.mvvm_full_tutorial.data.repository

import com.kotlin.tutorialone.mvvm_full_tutorial.data.db.AppDatabase
import com.kotlin.tutorialone.mvvm_full_tutorial.data.network.MyApi
import com.kotlin.tutorialone.mvvm_full_tutorial.data.network.SafeApiRequest

class QuotesRepository(private val myApi: MyApi,
                       private val db: AppDatabase
): SafeApiRequest() {

}