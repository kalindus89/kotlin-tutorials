package com.kotlin.tutorialone.oop_kotlin

abstract class Mammal(private var name:String, private var origin:String, private var weight:Double){

    //Abstract property must overridden by subclass
    abstract var maxSpeed:Double

    //Abstract methods also must overridden by subclass
    abstract fun run()
    abstract fun breath()

    //non abstract method
    fun displayDetails(){
        println("name $name orgin $origin weight $weight maxseed $maxSpeed")
    }

}

class Human(name: String, origin: String, weight: Double, override var maxSpeed: Double)
    :Mammal(name, origin, weight){
    override fun run() {
        println("has 2 legs")
    }

    override fun breath() {
        println("breath through nose or mouth")
    }

}

class Elephant(name: String, origin: String, weight: Double, override var maxSpeed: Double)
    :Mammal(name, origin, weight){
    override fun run() {
        println("has 4 legs")
    }

    override fun breath() {
        println("breath through nose")
    }

}

fun main(){
    val human =Human("Supun","Sri Lanka",70.0,10.0)
    val elephant =Elephant("Elephant","Africa",170.0,5.0)

    human.run()
    elephant.run()

    println("\n")

    human.breath()
    elephant.breath()

    println("\n")

    human.displayDetails()
    elephant.displayDetails()
}
