package com.kotlin.tutorialone.navigation_components

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.kotlin.tutorialone.R

class SecondFragment : Fragment() {

    val getPassedArgumentValues : SecondFragmentArgs by navArgs() // val type.. get the value passed from fragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_second, container, false)

        var backToFirst = view.findViewById<Button>(R.id.backToFirst)
        var nextToThird = view.findViewById<Button>(R.id.nextToThird)

        var txt = view.findViewById<TextView>(R.id.txt2)

        txt.text=getPassedArgumentValues.testNumber.toString()

        backToFirst.setOnClickListener {

            Navigation.findNavController(view).navigate(R.id.to_firstFragment2)

        }

        nextToThird.setOnClickListener {

            Navigation.findNavController(view).navigate(R.id.to_thirdFragmentFrom2)

        }
        return view
    }

}