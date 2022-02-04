package com.kotlin.tutorialone.calculator_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.kotlin.tutorialone.R

class CalculatorActivity : AppCompatActivity() {



    private  var numberEnter: TextView? =null // or below way. then when you set values put ? also

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_calculator)

        numberEnter=findViewById(R.id.numberEnter)
    }

    fun onDigit(view: View){ // this method trigger when any button click
        numberEnter?.append((view as Button).text ) // append ,add characters to end automatically

    }
}