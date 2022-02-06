package com.kotlin.tutorialone.navigation_componet_two

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kotlin.tutorialone.R

class NavigationComponentSecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_component_second)
        supportActionBar?.hide()
    }
}