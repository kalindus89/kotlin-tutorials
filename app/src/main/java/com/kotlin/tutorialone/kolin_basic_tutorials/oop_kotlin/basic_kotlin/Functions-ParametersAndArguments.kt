package com.kotlin.tutorialone

fun main() {

    myFunction();
    myFunctionPassing(10, "kalindu")
    var getReturnNumber = myFunctionReturnValue(10, 20)
    println("total $getReturnNumber")
}


fun myFunction() {

    println("call from main function")

}

fun myFunctionPassing(num: Int, str: String) {

    println("Num $num and $str")

}

fun myFunctionReturnValue(num: Int, num2:Int): Int {
    return (num+num2);
}