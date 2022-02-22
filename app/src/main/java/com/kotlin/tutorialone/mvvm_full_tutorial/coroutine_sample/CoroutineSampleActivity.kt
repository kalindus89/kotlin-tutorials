package com.kotlin.tutorialone.mvvm_full_tutorial.coroutine_sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.tutorialone.R
import com.kotlin.tutorialone.mvvm_full_tutorial.data.db.entities.Quotes
import com.kotlin.tutorialone.mvvm_full_tutorial.data.network.MyApi
import com.kotlin.tutorialone.mvvm_full_tutorial.data.network.NetworkConnectorInterceptor
import com.kotlin.tutorialone.mvvm_full_tutorial.data.network.response.QuotesResponseModel
import com.kotlin.tutorialone.mvvm_full_tutorial.ui.home.quotes.MvvmQuotesViewModel
import com.kotlin.tutorialone.mvvm_full_tutorial.ui.home.quotes.QuotesRecyclerAdapter
import com.kotlin.tutorialone.mvvm_full_tutorial.ui.home.quotes.QuotesViewModelFactory
import com.kotlin.tutorialone.mvvm_retrofit.views.MoviesRecyclerAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class CoroutineSampleActivity : AppCompatActivity() {


    private lateinit var coTestRecyclerView: RecyclerView
    private lateinit var viewModel: CoroutineViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine_sample)

        val runWebService=findViewById<Button>(R.id.runWebService)

        coTestRecyclerView=findViewById<RecyclerView>(R.id.coTestRecyclerView)

        coTestRecyclerView.also {
            it.layoutManager= LinearLayoutManager(this@CoroutineSampleActivity)
            it.setHasFixedSize(true)
        }

        runWebService.setOnClickListener {

            lifecycleScope.launch {

                coTestRecyclerView.adapter= QuotesRecyclerAdapter(getQuotesCoroutineWay())
            }

        }

        val factory= CoroutineViewModelFactory(this)
        viewModel = ViewModelProvider(this, factory).get(CoroutineViewModel::class.java)
        viewModel.quotes.observe(this, Observer {
            coTestRecyclerView.adapter= QuotesRecyclerAdapter(it)
        })

    }

    private suspend fun getQuotesCoroutineWay() :List<Quotes>{

        return withContext(Dispatchers.IO){
            MyApi(NetworkConnectorInterceptor(this@CoroutineSampleActivity)).getQuotesForCoroutine().body()?.quotes!!
        }

     //   Toast.makeText(this@CoroutineSampleActivity, getApiResponse.isSuccessful.toString(), Toast.LENGTH_SHORT).show()
    }


    fun getQuotesNormalWay(){
       val networkConnectorInterceptor = NetworkConnectorInterceptor(this)
       val api = MyApi(networkConnectorInterceptor).getQuotesForCoroutineNormalWay()
       api.enqueue( object : retrofit2.Callback<QuotesResponseModel>{
           override fun onResponse(call: Call<QuotesResponseModel>?, response: Response<QuotesResponseModel>?) {

               if(response?.body() != null) {
                   var qq: QuotesResponseModel= response.body()!!
               }

           }

           override fun onFailure(call: Call<QuotesResponseModel>?, t: Throwable?) {
               Toast.makeText(this@CoroutineSampleActivity, "fail", Toast.LENGTH_SHORT).show()

           }
       })
    }

}