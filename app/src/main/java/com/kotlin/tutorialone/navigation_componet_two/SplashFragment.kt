package com.kotlin.tutorialone.navigation_componet_two

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.kotlin.tutorialone.R


class SplashFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_splash, container, false)


        Handler().postDelayed({
            Navigation.findNavController(view).navigate(R.id.viewpagerFragment)
        },3000)

        return view
    }


}