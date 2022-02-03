package com.kotlin.tutorialone.oop_kotlin


//Supper class
open class Cars(val name: String, val brand: String) {

  open var range:Double=0.0;

    fun extendedRange(extendRange:Double){
        if(extendRange>0){
            range+=extendRange
        }
    }

    open fun drivingDistance(distance:Double){

        println("drove for $distance km")
    }

}

//subclass. Or subclass of Cars. must have at-least primary constructor parameters of super class.
open class ElectricalCars(var carName: String, carBrand: String, batteryLife: Double)
    : Cars(carName, carBrand) {

    override var range: Double=batteryLife*10 // override the super class variable makesure its open

    override fun drivingDistance(distance: Double) {
        super.drivingDistance(distance)
        println("drove $carName for $distance km")
    }

    fun drivingDistance() {
        println("drove $carName from battery $range km")
    }


}

/*//subclass. Or subclass of ElectricalCars
class HybridCars(carName: String, carBrand: String, batteryLife: Double) : ElectricalCars(carName, carBrand,
    batteryLife
) {

}*/

fun main(){

    var cars = Cars("BMW", "M8")
    var electricalCars = ElectricalCars("Tesla", "trx",8.9)

    // Polymorphism
    cars.drivingDistance(250.0)
    electricalCars.drivingDistance(200.0) // from override method in ElectricalCars

    electricalCars.extendedRange(150.0) // from car supper class
    electricalCars.drivingDistance() // from  method in ElectricalCars

}