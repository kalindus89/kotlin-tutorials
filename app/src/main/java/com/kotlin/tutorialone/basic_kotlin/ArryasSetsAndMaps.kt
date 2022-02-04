package com.kotlin.tutorialone.basic_kotlin

fun main(){

    //---------------------------sets---------------------------------

    var fruits= setOf("Mango","Banana", "Apple","Orange","Mango", "Apple") // set ignore the duplicates
    println("size of fruits ${fruits.size}") // set ignore the duplicates

    val newFruits=fruits.toMutableList()

    newFruits.add("Grapes")
    newFruits.add("Water Melon")
   // newFruits.addAll(fruits)

    println("Merge sets $newFruits and size is ${newFruits.size}")
    println("Get value from index ${newFruits.elementAt(3)} ")
    println("\n")


    //---------------------------maps---------------------------------

    var daysOfWeeks= mapOf(2 to "mon", 10 to "tue", 7 to "wed", 4 to "thu") // key and values
    println("day is ${daysOfWeeks[4]}")


    for (getDays in daysOfWeeks){
        println("day is ${getDays.key} - ${getDays.value}")
    }
    //or
    for (getDays in daysOfWeeks.keys){
        println("day is from keys ${getDays} - ${daysOfWeeks[getDays]}")
    }

    var sortDaysMapFromKey =daysOfWeeks.toMutableMap()
    sortDaysMapFromKey[7]="Sat" // replace key 7 with sat
    println("Sort map from keys ${sortDaysMapFromKey.toSortedMap()}")




    var fruitsClass = mapOf("f1" to FruitsClass("Banana",100.0), "f2" to FruitsClass("Mango",120.0)
        ,"f3" to FruitsClass("Apple",80.0)) // key can be a string also


    for (getFruitsClass in fruitsClass){

        println("fruits ${getFruitsClass.key} - ${getFruitsClass.value.name}  - ${getFruitsClass.value.price}")
    }

}

class FruitsClass(var name:String, var price:Double)