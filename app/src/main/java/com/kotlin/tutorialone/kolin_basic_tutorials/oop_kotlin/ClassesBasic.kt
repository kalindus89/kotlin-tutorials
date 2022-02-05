package com.kotlin.tutorialone.kolin_basic_tutorials.oop_kotlin

fun main(){

    var person = Person();
    var person2 = Person2("Kalindu","Supun");
    var person3 = Person3(); // Default values will print
    var person4 = Person3(lName = "Hettirachchi"); // fName Default values will print and lName passing value will print

    var person5 = Person5(fName = "Kalidnu");
    person5.getHobby()

    person5.fName="Sudpun" //changing values overwritten
    person5.hobby="Playing football" //changing values for public variables overwritten
    person5.getHobby()


    var person6 = Person5( "Kalidnu", "Supun",30);
    person6.getHobbyAndAge()
    person6.age=34 // age overwritten
    person6.getHobbyAndAge()



}

class Person(){

    init { // like initialized method or first running method

        println("First method run")
    }
}

class Person2(fName:String, lName:String  ){ // passing value to constructor

    init{
        println("Second method $fName and $lName")
    }

}

class Person3(fName:String="DefaultFName", lName:String="DefaultLName"  ){ // passing value to constructor

    init{
        println("Second method $fName and $lName")
    }

}

class Person5(fName:String="DefaultFName", lName:String="DefaultLName"  ){ // passing value to constructor

    var fName:String?=null
    var lName:String?=null
    var age:Int?=null
    var hobby ="No hobby"

    init{
        this.fName=fName;
        this.lName=lName;
    }

    constructor(fName:String, lName:String, age:Int):this(fName,lName){ // secondary constructor. fname lname get from above
        this.age=age;
    }

    public fun getHobby(){
        println("$fName hobby is $hobby")
    }

    public fun getHobbyAndAge(){
        println("$fName $lName hobby is $hobby my age is $age")
    }



}
