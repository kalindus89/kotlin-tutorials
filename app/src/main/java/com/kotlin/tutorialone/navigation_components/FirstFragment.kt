package com.kotlin.tutorialone.navigation_components

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import com.kotlin.tutorialone.R

class FirstFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_first, container, false)

        var nextToSecond=view.findViewById<TextView>(R.id.nextToSecond)

        nextToSecond.setOnClickListener {


            var userModel=UserModel("kalindu","Supun")

            //https://www.youtube.com/watch?v=vx1-V3HH0IU&list=PLSrm9z4zp4mHilvsfUM3jeCYFV3fTAS3J&index=2
            val action = FirstFragmentDirections.toSecondFragmentFrom1(userModel) // passing values to 2nd fragments. sync safegard in both gradles
            Navigation.findNavController( view).navigate(action) // no need R.id here because it defines in above line

        }

        return view
    }


}