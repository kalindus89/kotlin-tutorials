package com.kotlin.tutorialone.mvvm_retrofit.views

import android.view.View
import com.kotlin.tutorialone.mvvm_retrofit.models.ModelResponse
import com.kotlin.tutorialone.mvvm_retrofit.models.ModelResponseDisney

interface RecyclerClickListener {

    fun onRecyclerItemClick(view: View, movie: ModelResponse)
    fun onRecyclerItemClickDisney(view: View, movie: ModelResponseDisney
    )

}

