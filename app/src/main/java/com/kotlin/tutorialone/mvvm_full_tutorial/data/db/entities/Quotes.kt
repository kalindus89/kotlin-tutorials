package com.kotlin.tutorialone.mvvm_full_tutorial.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Quotes(

    @PrimaryKey(autoGenerate = false)
    val id:Int,
    val quote:String,
    val author:String
)
