package com.kotlin.tutorialone.navigation_components

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavArgument
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.kotlin.tutorialone.R

class NavigationComponentActivity : AppCompatActivity() {

    private lateinit var navController:NavController
    private lateinit var drawerLayout:DrawerLayout
    private lateinit var navigationView:NavigationView
    private lateinit var appBarConfiguration:AppBarConfiguration
    private lateinit var bottom_nav2:BottomNavigationView

    private lateinit var listener:NavController.OnDestinationChangedListener


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_navigation_componet)


        navController=findNavController(R.id.fragmentContainerView) // change FragmentContainerView to fragment

        bottom_nav2=findViewById(R.id.bottom_nav2);
        bottom_nav2.setupWithNavController(navController)

        navigationView=findViewById(R.id.navigationView)
        navigationView.setupWithNavController(navController)

        drawerLayout=findViewById(R.id.drawerLayout)

        appBarConfiguration= AppBarConfiguration(navController.graph,drawerLayout)
        setupActionBarWithNavController(navController,appBarConfiguration)

        listener=NavController.OnDestinationChangedListener{controller, destination, arguments ->

            if (destination.id==R.id.firstFragment){
                supportActionBar?.setBackgroundDrawable(ColorDrawable(getColor(R.color.purple_200)))
            } else if (destination.id==R.id.secondFragment){
                supportActionBar?.setBackgroundDrawable(ColorDrawable(getColor(R.color.teal_200)))
            } else if (destination.id==R.id.thirdFragment){
                supportActionBar?.setBackgroundDrawable(ColorDrawable(getColor(R.color.purple_700)))
            }
        }

    }

//control + o to get override methods
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration)||super.onSupportNavigateUp()
    }


    override fun onResume() {
        super.onResume()
        navController.addOnDestinationChangedListener(listener)
    }

    override fun onPause() {
        super.onPause()
        navController.removeOnDestinationChangedListener(listener)

    }

}