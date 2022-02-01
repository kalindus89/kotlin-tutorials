package com.kotlin.tutorialone

fun main(){

    var myName="Kalindu"; // var values can change.Like final in java
    println("My name $myName")

    myName="Supun";
    println("My name change to $myName")

    val myAddress="Sri Lanka"; // val values can't change
    println("My address $myAddress")


    // TODO : show in the TODO tab near logcat

    var number = 23.4; // no need datatype If you want data type add ": datatype"
    var number1 : Int =10; //

    println( "Numbers "+(number+number1).toString())

    var booleanValues=false
    booleanValues=true

    println("boolean value $booleanValues")

    //Accessing a character
    val myStr = "MyString"
    var firstChar= myStr[5]; // returning 5th character [0,1,2,3,4]
    var lastChar= myStr[myStr.length-1]; // returning last character

    println("Character $firstChar")
    println("Last Character $lastChar")

    println("Concatenation $lastChar is the last character and ${myStr.length} is the length")




}