package com.kotlin.tutorialone.mvvm_full_tutorial.data.network

import com.kotlin.tutorialone.mvvm_full_tutorial.utils.ApiExceptionss
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response
import java.io.IOException
import java.lang.StringBuilder

abstract class SafeApiRequest {

    // get the response and handle errors here. so we can abstract(isolate) the response
    suspend fun <T : Any> apiRequest(call: suspend () -> Response<T>): T {
        val response =
            call.invoke()  //invoke()  can be called on any instances of the class without a method name!
        if (response.isSuccessful) {
            return response.body()!! // !!not nullable
        } else {

            val message = StringBuilder()

            val error = response.errorBody()?.string()
            error?.let {
                try {
                     message.append(JSONObject(it).getString("message"))
                } catch (e: JSONException) {

                    message.append("\n")
                }
            }

            message.append("Error code: ${response.code()}")

            throw ApiExceptionss(message.toString())

        }
    }
}

class ApiExceptions(msg: String) : IOException(msg)