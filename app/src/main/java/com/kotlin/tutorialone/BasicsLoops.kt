package com.kotlin.tutorialone

fun main(){

    var num =1;
    var num2=1;


    while (num<=10){
        print(" $num ")
        num++
    }

    println("\n")
    do{
        print(" $num2 ")
        num2++
    }while (num2<=10)


    println("\n")
    for(number in 1..10){
        print("$number ")
    }


    println("\n")
    for(number  in 1 until 10){ // 10 not count
        print("$number ")
    }

    println("\n")
    for(number  in 10 downTo 1){
        print("$number ")
    }

    println("\n")
    for(number  in 1 until 10 step 2){ // +2
        print("$number ")
    }

    println("\n")
    for(number  in 10 downTo 1 step 2){ // -2
        print("$number ")
    }
}