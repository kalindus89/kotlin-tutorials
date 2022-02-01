package com.kotlin.tutorialone

fun main(){

    // TODO : show in the TODO tab near logcat

    var myName="Kalindu"; // var values can change.Like final in java
    val myAddress="Sri Lanka"; // val values can't change
    var number = 23.4; // no need datatype If you want data type add ": datatype"
    var number1 : Int =10; //
    var booleanValues=false
    //Accessing a character
    val myStr = "MyString"
    var firstChar= myStr[5]; // returning 5th character [0,1,2,3,4]
    var lastChar= myStr[myStr.length-1]; // returning last character
    var total=4
    val a=20
    val b=20

    // Assignment operators (+=, -=, *=, /=, %=)
    // increment and decrement operators( ++num num++ --num num--)

    println("My name $myName")
    myName="Sri Lanka";
    println("My name change to $myName")
    println("My address $myAddress")
    println( "Numbers "+(number+number1).toString())
    booleanValues=true
    println("boolean value $booleanValues")
    println("Character $firstChar")
    println("Last Character $lastChar")
    println("Concatenation $lastChar is the last character and ${myStr.length} is the length")
    println("total ${total+a+b}")


    if(myName.equals(myAddress)){
        println("both equal")
    }else{
        println("not equal")
    }

    when(total) { // without if else we can replace with when
        2 -> {
            println("total is 2")
        }
        in 2..10 -> {
            println("total between 2 and ten")
        }
        is Int -> {
            println("is int")
        }
        else -> {
            println("a smaller than b")
        }
    }




}