package com.kotlin.tutorialone.mvvm_full_tutorial.coroutine_sample

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kotlin.tutorialone.mvvm_full_tutorial.data.db.entities.Quotes
import com.kotlin.tutorialone.mvvm_full_tutorial.data.network.MyApi
import com.kotlin.tutorialone.mvvm_full_tutorial.data.network.NetworkConnectorInterceptor
import com.kotlin.tutorialone.mvvm_full_tutorial.data.repository.QuotesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CoroutineViewModel(context: Context) : ViewModel() {

    val quotes:LiveData<List<Quotes>> = MutableLiveData()

    init {

        viewModelScope.launch {

            quotes as MutableLiveData //  need to caste

         //   quotes.value= getQuotesCoroutineWay(context) or

           // val quotess= async { getQuotesCoroutineWay(context) } // async return a value and run multiple network requests parallel or concurrently
            //quotes.value= quotess.await() // await must call to get the values if we use async


            for (i in 1..5){
                val quotes1 =  async { getQuotesCoroutineWay(context) } // async return a value and run multiple network requests parallel or concurrently.  await must call to get the values if we use async
                val quotes2 =  async { getQuotesCoroutineWay(context) }
                val quotes3 = async { getQuotesCoroutineWay(context) }

                val quotes4 = async { getQuotesCoroutineWaySecond(context) }
                val quotes5 = async { getQuotesCoroutineWaySecond(context) }
                val quotes6 = async { getQuotesCoroutineWaySecond(context) }

            }


        }

    }

    private suspend fun getQuotesCoroutineWay(context: Context) :List<Quotes>{

        return withContext(Dispatchers.IO){
            android.util.Log.e("TAG","First")
            MyApi(NetworkConnectorInterceptor(context)).getQuotesForCoroutine().body()?.quotes!!
        }

        //   Toast.makeText(this@CoroutineSampleActivity, getApiResponse.isSuccessful.toString(), Toast.LENGTH_SHORT).show()
    }

    private suspend fun getQuotesCoroutineWaySecond(context: Context) :List<Quotes>{

        return withContext(Dispatchers.IO){
            android.util.Log.e("TAG","Second")
            MyApi(NetworkConnectorInterceptor(context)).getQuotesForCoroutineSecond().body()?.quotes!!
        }

        //   Toast.makeText(this@CoroutineSampleActivity, getApiResponse.isSuccessful.toString(), Toast.LENGTH_SHORT).show()
    }


}