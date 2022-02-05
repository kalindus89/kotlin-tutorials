package com.kotlin.tutorialone.calculator_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.kotlin.tutorialone.R
import java.lang.ArithmeticException

class CalculatorActivity : AppCompatActivity() {

    private  var txtInput: TextView? =null // or below way. then when you set values put ? also
    var lastNumeric:Boolean = false;
    var lastDot:Boolean = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_calculator)
        txtInput=findViewById(R.id.txtInput)
    }

    fun onDigit(view: View){ // this method trigger when number button click
        lastNumeric=true
        txtInput?.append((view as Button).text ) // append ,add characters to end automatically

    }

    fun onClear(view: View){ // this method trigger when clear button click
        lastDot=false
        lastNumeric=true
        txtInput?.text=""

    }

    fun onDecimalPoint(view: View){ // this method trigger when . button click

        if(lastNumeric && !lastDot){ // if dot already there not adding to textview

            txtInput?.append(".")
            lastDot=true
            lastNumeric=false
        }
    }

    fun onOperate(view:View){

        txtInput?.text?.let { // only if not null

            println("aaa "+!isOperatorClicked(it.toString()))

            if(lastNumeric && !isOperatorClicked(it.toString())){ //system 'it' is txtInput

                txtInput?.append((view as Button).text)
                lastNumeric=false
                lastDot=false

            }
        }

    }

    fun onEqual(view:View){

        if(lastNumeric){

           var txtValue =txtInput?.text.toString()
            var prefix=""

            try {

                if(txtValue.startsWith("-")){
                    prefix="-"
                    txtValue=txtValue.substring(1)
                }
                if(txtValue.contains("-")) {
                    var splitValue = txtValue.split("-") // eg: 99-1 into 99 and 1

                    var valueOne = splitValue[0] //99
                    var valueTwo = splitValue[1] //1

                    if(prefix.isNotEmpty()){
                        valueOne=prefix+valueOne
                    }

                    txtInput?.text = removeDotAndZero((valueOne.toDouble() - valueTwo.toDouble()).toString())
                }
                if(txtValue.contains("+")) {
                    var splitValue = txtValue.split("+") // eg: 99-1 into 99 and 1

                    var valueOne = splitValue[0] //99
                    var valueTwo = splitValue[1] //1

                    if(prefix.isNotEmpty()){
                        valueOne=prefix+valueOne
                    }

                    txtInput?.text = removeDotAndZero((valueOne.toDouble() + valueTwo.toDouble()).toString())
                }
                if(txtValue.contains("*")) {
                    var splitValue = txtValue.split("*") // eg: 99-1 into 99 and 1

                    var valueOne = splitValue[0] //99
                    var valueTwo = splitValue[1] //1

                    if(prefix.isNotEmpty()){
                        valueOne=prefix+valueOne
                    }

                    txtInput?.text = removeDotAndZero((valueOne.toDouble() * valueTwo.toDouble()).toString())
                }
                if(txtValue.contains("/")) {
                    var splitValue = txtValue.split("/") // eg: 99-1 into 99 and 1

                    var valueOne = splitValue[0] //99
                    var valueTwo = splitValue[1] //1

                    if(prefix.isNotEmpty()){
                        valueOne=prefix+valueOne
                    }

                    txtInput?.text = removeDotAndZero((valueOne.toDouble() / valueTwo.toDouble()).toString())
                }

            }catch (e:ArithmeticException){
                e.printStackTrace()
            }
        }

    }

    private fun isOperatorClicked(value:String):Boolean{


        return if(value.startsWith("-")){// this returns either ture or false
            false
        }else{
            value.contains("+")||value.contains("-")||value.contains("*")||value.contains("/")

        }

    }

    private fun removeDotAndZero(value:String):String{

        var result=value
        if(result.contains(".0")){
            result=value.substring(0,value.length-2)
        }
        return result

    }
}