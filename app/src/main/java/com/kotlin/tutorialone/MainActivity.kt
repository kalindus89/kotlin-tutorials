package com.kotlin.tutorialone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    val fName:String="bbb"  // val cannot change. like final in java
    var job:String="Se" // var can change
    var number = 0 // var can change


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val clickNow= findViewById<Button>(R.id.click_now)
        val countNum= findViewById<TextView>(R.id.count_num)

        clickNow.setOnClickListener {

            clickNow.text="Click Me"

            number += 1;
            countNum.text= number.toString()
            Toast.makeText(this, number.toString(), Toast.LENGTH_SHORT).show()
        }

       initFun();

    }

    fun initFun(){

        job="AE"
        println("aaaaaa $fName $job");

    }
}