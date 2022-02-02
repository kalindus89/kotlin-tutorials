package com.kotlin.tutorialone.oop_kotlin

fun main(){

    var person = Person();
    var person2 = Person2("Kalindu","Supun");
    var person3 = Person3(); // Default values will print
    var person4 = Person3(lName = "Hettirachchi"); // fName Default values will print and lName passing value will print
}

class Person(){

    init { // like initialized method or first running method

        println("First method run")
    }
}

class Person2(var fName:String, var lName:String  ){ // passing value to constructor

    init{
        println("Second method $fName and $lName")
    }

}

class Person3(var fName:String="DefaultFName", var lName:String="DefaultLName"  ){ // passing value to constructor

    init{
        println("Second method $fName and $lName")
    }

}
