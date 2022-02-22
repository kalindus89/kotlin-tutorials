package com.kotlin.tutorialone.mvvm_full_tutorial.coroutine_sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.kotlin.tutorialone.R
import com.kotlin.tutorialone.mvvm_full_tutorial.data.network.MyApi
import com.kotlin.tutorialone.mvvm_full_tutorial.data.network.NetworkConnectorInterceptor
import com.kotlin.tutorialone.mvvm_full_tutorial.data.network.response.QuotesResponseModel
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class CoroutineSampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine_sample)

        val runWebService=findViewById<Button>(R.id.runWebService)

        runWebService.setOnClickListener {


            val networkConnectorInterceptor = NetworkConnectorInterceptor(this)
            val api = MyApi(networkConnectorInterceptor).getQuotesForCoroutine()
            api.enqueue( object : retrofit2.Callback<QuotesResponseModel>{
                override fun onResponse(call: Call<QuotesResponseModel>?, response: Response<QuotesResponseModel>?) {

                    if(response?.body() != null) {
                        var qq: QuotesResponseModel= response.body()!!
                        Toast.makeText(this@CoroutineSampleActivity, qq.isSuccessful.toString(), Toast.LENGTH_SHORT).show()
                    }

                }

                override fun onFailure(call: Call<QuotesResponseModel>?, t: Throwable?) {
                    Toast.makeText(this@CoroutineSampleActivity, "fail", Toast.LENGTH_SHORT).show()

                }
            })
            //apiInterface.enqueue( Callback<List<Movie>>())


        }

    }
}