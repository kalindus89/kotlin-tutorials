package com.kotlin.tutorialone.kolin_basic_tutorials.oop_kotlin

import java.lang.IllegalArgumentException

fun main() {

    var myCar = Car()
    println(myCar.carBrand)

    myCar.maxSpeed=300
    println(myCar.maxSpeed)

    myCar.maxSpeed=400
    println(myCar.maxSpeed)


   //  myCar.carModel="M60" this is not possible because it's set to private
    println(myCar.carModel)
    println(myCar.getUerCarModel())




}


class Car() {
    lateinit var owner: String; // later define the value.


    init {
        owner = "Kalindu"
    }


    //no need get or set it can already access. but in loigc or any change happen then we need get and set

    var carBrand: String = "BMW"
        get() {
            return field.lowercase(); // return value of maxSpeed
        }
    //get() =field.lowercase() //same as above

    var maxSpeed: Int = 200
        set(value) {
            field = if(value>0) value else throw IllegalArgumentException("Max speed must be positive number")
        }

    var carModel:String ="M20"
    private set // this means carmodel value cannot change. If you want change change has to do inside a method. Like below

    fun getUerCarModel():String {
        carModel="M60";
        return carModel;
    }
}