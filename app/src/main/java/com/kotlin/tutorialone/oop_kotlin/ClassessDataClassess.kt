package com.kotlin.tutorialone.oop_kotlin

//A data class is a class that only contains state and does not perform any operation
// must have at-least one parameter to primary constructor

data class User(var id:Long, var name:String)

fun main(){

    var user1=User(1,"kalindu")
    var user2=User(1,"Supun")

     user1.id=2; // can change values
    var id = user1.id
    println("id $id")

    var name=user1.name;
    var name2=user2.name;

    println("name1 $name")
    println("name2 $name2")
    println("is equal ${name == name2}")


    var copyObject =user2.copy(id = 5, name="supunChange") // can copy objects and change values also
    println("id of copyObject ${copyObject.component1()}") //component1() is first constructor parameter. that is id
    println("name of copyObject ${copyObject.component2()}") //component2() is second constructor parameter. that is name

    val(newId,newName)=copyObject // easily set new values in this way
    println("new id $newId - new name $newName")






}