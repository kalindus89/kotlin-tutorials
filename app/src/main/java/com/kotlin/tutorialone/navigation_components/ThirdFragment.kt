package com.kotlin.tutorialone.navigation_components

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import com.kotlin.tutorialone.R

class ThirdFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_third, container, false)
        var txt = view.findViewById<TextView>(R.id.txt3)

        txt.setOnClickListener {

            Navigation.findNavController(view).navigate(R.id.to_secondFragmentFrom3)

        }
        return view
    }

}