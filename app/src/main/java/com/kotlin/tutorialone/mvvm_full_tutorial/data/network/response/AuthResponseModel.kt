package com.kotlin.tutorialone.mvvm_full_tutorial.data.network.response

import com.kotlin.tutorialone.mvvm_full_tutorial.data.db.entities.UserEntity

data class AuthResponseModel(val message:String?,
                             val isSuccessful:Boolean?,
                             val user:UserEntity?) {
}