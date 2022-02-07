package com.kotlin.tutorialone.mvvm_retrofit.views

import android.view.View
import com.kotlin.tutorialone.mvvm_retrofit.models.ModelResponse

interface RecyclerClickListener {

    fun onRecyclerItemClick(view: View, movie: ModelResponse)

}

