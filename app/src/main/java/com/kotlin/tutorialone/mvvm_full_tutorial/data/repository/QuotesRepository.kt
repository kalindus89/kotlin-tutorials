package com.kotlin.tutorialone.mvvm_full_tutorial.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kotlin.tutorialone.mvvm_full_tutorial.data.db.AppDatabase
import com.kotlin.tutorialone.mvvm_full_tutorial.data.db.entities.Quotes
import com.kotlin.tutorialone.mvvm_full_tutorial.data.network.MyApi
import com.kotlin.tutorialone.mvvm_full_tutorial.data.network.SafeApiRequest
import com.kotlin.tutorialone.mvvm_full_tutorial.utils.Coroutiness
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuotesRepository(private val myApi: MyApi, private val db: AppDatabase): SafeApiRequest() {

    private val quotes =MutableLiveData<List<Quotes>>()

    init {
        quotes.observeForever{ // when ever there a change in the api this will automatically trigger
            saveQuotes(it)
        }
    }


    public suspend fun getQuotes():LiveData<List<Quotes>>{
      return withContext(Dispatchers.IO){
          fetchQuotes()
          db.getQuoteDao().getQuotes()
      }
    }



    private suspend fun fetchQuotes(){

        if(isFetchNeeded()){
            val response=apiRequest { myApi.getQuotes()   }
            quotes.postValue(response.quotes)
        }
    }

    private fun isFetchNeeded(): Boolean {
        return true
    }


    private fun saveQuotes(quotes: List<Quotes>){
        Coroutiness.io {
            db.getQuoteDao().saveAllQuotes(quotes)
        }
    }

}