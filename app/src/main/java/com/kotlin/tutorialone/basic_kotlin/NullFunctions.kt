package com.kotlin.tutorialone

fun main() {

    var notNullName: String = "Kalindu";
    var nullName: String? = null;

    println("nullName length ${notNullName.length}")
    //println("null name length ${nullName.length}") // this is not working because its null. you need condition;

    var len = notNullName.length;
    var len2 = nullName?.length // same as if else. ? check null or not

    println("nullName length $len2") // print null

    nullName ="Supun"
    len2 = nullName?.length
    nullName?.let { println("print only if not null ${it.length}") } //print only if not null


    nullName=null;

    val ifNullSetDefaultName =nullName?:"Hupun" // if variable is null assigning a default string ?: elvis operator
    println("Default name $ifNullSetDefaultName")





}