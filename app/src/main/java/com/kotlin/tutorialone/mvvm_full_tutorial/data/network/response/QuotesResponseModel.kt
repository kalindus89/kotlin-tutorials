package com.kotlin.tutorialone.mvvm_full_tutorial.data.network.response

import com.kotlin.tutorialone.mvvm_full_tutorial.data.db.entities.Quotes

data class QuotesResponseModel(
    val isSuccessful:Boolean,
    val quotes:List<Quotes>
) {
}