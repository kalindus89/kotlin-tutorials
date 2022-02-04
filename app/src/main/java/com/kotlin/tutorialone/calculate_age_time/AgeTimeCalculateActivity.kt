package com.kotlin.tutorialone.calculate_age_time

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import com.kotlin.tutorialone.R
import java.text.SimpleDateFormat
import java.util.*

class AgeTimeCalculateActivity : AppCompatActivity() {

    private lateinit var selectBtn: Button //lateinit means initialize later
    private  var selectedDate: TextView? =null // or below way. then when you set values put ? also
    private  var inMinutes: TextView? =null // or below way. then when you set values put ? also

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_age_time_calculate)

        selectedDate=findViewById(R.id.selectedDate)
        inMinutes=findViewById(R.id.inMinutes)

        selectBtn=findViewById(R.id.selectBtn)
        selectBtn.setOnClickListener {

            clickDatePicker()

        }

    }

    private fun clickDatePicker(){

        val myCalender =Calendar.getInstance()
        val year =myCalender.get(Calendar.YEAR)
        val month =myCalender.get(Calendar.MONTH)
        val day =myCalender.get(Calendar.DATE)


     val dpd= DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener(fun(view: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDay: Int)
            {
                val temDate ="$selectedDay/${selectedMonth + 1}/$selectedYear"
                selectedDate?.text=temDate

                val sdf= SimpleDateFormat("dd/MM/yy", Locale.ENGLISH)

                val theDate=sdf.parse(temDate)

                theDate?.let { // if not null
                    val inMintsSelectedTime=(theDate.time/60000) //time is in millisecond (to 60*1000)

                    val inCurrentDate=sdf.parse(sdf.format(System.currentTimeMillis()))

                    val inCurrentDateInMints=(inCurrentDate.time/60000)

                    val differenceInMinutes = inCurrentDateInMints-inMintsSelectedTime

                    inMinutes?.text=differenceInMinutes.toString()

                }


            }), year,month,day)

        dpd.datePicker.maxDate=System.currentTimeMillis()-86400000 // not showing future days
        dpd.show()



    }
}