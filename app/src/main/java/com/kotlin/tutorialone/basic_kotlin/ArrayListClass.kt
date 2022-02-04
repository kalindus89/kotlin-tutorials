package com.kotlin.tutorialone.basic_kotlin

fun main(){

    val arrayList =ArrayList<String>(); // empty array list
    arrayList.add("Mon")
    arrayList.add("Tue")
    arrayList.add("Wed")
    arrayList.add("Thu")

    println("Size of arraylist ${arrayList.size}")
    println("${arrayList[2]}")

    for (getArray in arrayList){
        println("day $getArray")
    }
    //or
    for (getArray in arrayList.indices){
        println("day ${arrayList[getArray]}")
    }


    println("\n")


    val arrayList2 =ArrayList<String>(5) // limited to 5 etries
    val list= mutableListOf<String>()
    list.add("one")
    list.add("two")
    list.add("three")
    list.add("four")
    list.add("five")
    list.add("six")
    list.add("seven")
    arrayList2.addAll(list) // we can set values more than 5 using this way

    println(arrayList2)

    val itr =arrayList2.iterator()

    while (itr.hasNext()){
        println("get value ${itr.next()}")
    }

}