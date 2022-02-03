package com.kotlin.tutorialone.oop_kotlin

interface Drivable{

    val maxSpeed:Double
    fun drivingDistance():String
    fun brake(){
        println("Driver is braking")
    }


}

//Supper class
open class Cars(override val maxSpeed: Double,val name: String, val brand: String) : Drivable{

  open var range:Double=0.0;

    fun extendedRange(extendRange:Double){
        if(extendRange>0){
            range+=extendRange
        }
    }

    open fun drivingDistance(distance:Double){

        println("drove for $distance km")
    }


    //override fun drivingDistance(): String= "driving the interface drive" both same as below
    override fun drivingDistance(): String {
        return "driving the interface drive"
    }


}

//subclass. Or subclass of Cars. must have at-least primary constructor parameters of super class.
open class ElectricalCars(maxSpeed: Double,var carName: String, carBrand: String, batteryLife: Double)
    : Cars(maxSpeed,carName, carBrand) {

    override var range: Double=batteryLife*10 // override the super class variable makesure its open

    override fun drivingDistance(distance: Double) {
        super.drivingDistance(distance)
        println("drove $carName for $distance km")
    }

    override fun drivingDistance():String {
        return  "droveee $carName from battery $range km"
    }

    override fun brake() { // from interface class.
        super.brake() // run inside in interface method also.. comment it or delete if no need ot run
        println("Driver is braking electrical car")
    }


}

/*//subclass. Or subclass of ElectricalCars
class HybridCars(carName: String, carBrand: String, batteryLife: Double) : ElectricalCars(carName, carBrand,
    batteryLife
) {

}*/

fun main(){

    var cars = Cars(350.0,"BMW", "M8")
    var electricalCars = ElectricalCars(400.0,"Tesla", "trx",8.9)

    // Polymorphism
    cars.drivingDistance(250.0)
    electricalCars.drivingDistance(200.0) // from override method in ElectricalCars

    electricalCars.extendedRange(150.0) // from car supper class
    electricalCars.drivingDistance() // from  method in ElectricalCars

    println("\n${electricalCars.drivingDistance()}")
    electricalCars.brake()

}