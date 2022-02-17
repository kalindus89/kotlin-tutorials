package com.kotlin.tutorialone.mvvm_full_tutorial.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kotlin.tutorialone.mvvm_full_tutorial.data.db.AppDatabase
import com.kotlin.tutorialone.mvvm_full_tutorial.data.db.entities.Quotes
import com.kotlin.tutorialone.mvvm_full_tutorial.data.network.MyApi
import com.kotlin.tutorialone.mvvm_full_tutorial.data.network.SafeApiRequest
import com.kotlin.tutorialone.mvvm_full_tutorial.data.preferences.PreferenceProvider
import com.kotlin.tutorialone.mvvm_full_tutorial.utils.Coroutiness
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

private val MINIMUM_INTERVAL = 6

@RequiresApi(Build.VERSION_CODES.O)// time now()
class QuotesRepository(
    private val myApi: MyApi,
    private val db: AppDatabase,
    private val pref: PreferenceProvider,
) : SafeApiRequest() {

    private val quotes = MutableLiveData<List<Quotes>>()

    init {
        quotes.observeForever { // when ever there a change in the api this will automatically trigger
            saveQuotes(it)
        }
    }


    public suspend fun getQuotes(): LiveData<List<Quotes>> {
        return withContext(Dispatchers.IO) {
            fetchQuotes()
            db.getQuoteDao().getQuotes()
        }
    }


    private suspend fun fetchQuotes() {

        val lastSaveAt = pref.getLastSavedAt()

        if (lastSaveAt == null || isFetchNeeded(LocalDateTime.parse(lastSaveAt))) {

            val response = apiRequest { myApi.getQuotes() }
            quotes.postValue(response.quotes)

        }
    }

    private fun isFetchNeeded(saveAt: LocalDateTime): Boolean {
        return ChronoUnit.HOURS.between(saveAt, LocalDateTime.now()) > MINIMUM_INTERVAL
    }


    @RequiresApi(Build.VERSION_CODES.O) // time now()
    private fun saveQuotes(quotes: List<Quotes>) {

        Coroutiness.io {
            pref.saveLastSavedAt(LocalDateTime.now().toString())
            db.getQuoteDao().saveAllQuotes(quotes)
        }
    }

}