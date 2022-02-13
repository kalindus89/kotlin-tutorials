package com.kotlin.tutorialone.mvvm_full_tutorial.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView
import com.kotlin.tutorialone.R

class MvvmHomeActivity : AppCompatActivity() {

    lateinit var drawer_Layout:DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_mvvm_home)

        val toolbar:Toolbar=findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val navController =Navigation.findNavController(this,R.id.fragmentHost)

        val nav_view:NavigationView=findViewById(R.id.nav_view)
        NavigationUI.setupWithNavController(nav_view,navController)

        drawer_Layout=findViewById(R.id.drawer_Layout)
        NavigationUI.setupActionBarWithNavController(this,navController,drawer_Layout)

    }

    override fun onSupportNavigateUp(): Boolean { // makes menu drawerable
        return NavigationUI.navigateUp(
            Navigation.findNavController(this,R.id.fragmentHost),drawer_Layout
        )
    }
}