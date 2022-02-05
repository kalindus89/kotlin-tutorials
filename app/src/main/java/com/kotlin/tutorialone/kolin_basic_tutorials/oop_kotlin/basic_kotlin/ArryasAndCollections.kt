package com.kotlin.tutorialone.kolin_basic_tutorials.oop_kotlin.basic_kotlin

fun main(){

    // immutable arrays.  cant add or remove
    var numberArray:IntArray = intArrayOf(2,5,6,8,10) // below ways are also correct
        //var numberArray = intArrayOf(2,5,6,8,10)
         //var numberArray = arrayOf(2,5,6,8,10)

    println(numberArray[0])

    for (nxtNumber:Int in numberArray){ // nxtNumber is the numberArray value
        println("$nxtNumber")
    }
    //or
    for (nxtNumber in numberArray.indices){ // nxtNumber is the index of numberArray
        println(numberArray[nxtNumber])
    }


    var dayArray = arrayOf("Mon","Tue,","Wed","Thu","Fri")
    println(dayArray.contentToString())


    val fruitsArray= arrayOf(
        Fruits("Mango",10.0) ,
        Fruits("Banana",21.0) ,
        Fruits("Apple",11.0) )

    for (fruits:Fruits in fruitsArray){ // nxtNumber is the numberArray value
        println(fruits.name +" "+fruits.price)
    }
    //or
    for (fruits in fruitsArray.indices){ // nxtNumber is the numberArray value
        println(fruitsArray[fruits].name +" "+fruitsArray[fruits].price)
    }





}

class Fruits(val name:String, val price:Double)