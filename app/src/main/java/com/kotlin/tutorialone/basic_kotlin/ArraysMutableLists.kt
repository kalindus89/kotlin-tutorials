package com.kotlin.tutorialone.basic_kotlin

import androidx.lifecycle.MutableLiveData


fun main(){

    val months = listOf<String>("Jan","Feb","Mar")
    val newMonths=months.toMutableList()
    //or val monthss = mutableListOf<String>("Jan","Feb","Mar")

    newMonths.add("Apr")
    val month2 = listOf<String>("May","Jun","Jul")
    newMonths.addAll(month2)

    println(newMonths)

    val days = mutableListOf<String>("sun","mon","tue","wed")
    days.add("thu")
    days[1]="fri" //change the value
    days.removeAt(2)//remove the element "wed"
    println(days)


    val days2 = mutableListOf<String>("sun","mon")
    days.removeAll(days2) // remove elements
    println(days)


}