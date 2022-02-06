package com.kotlin.tutorialone.navigation_componet_two.on_boarding.fragments_screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.kotlin.tutorialone.R


class SecondFragmentScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_second_screen, container, false)

        val view_pager= activity?.findViewById<ViewPager2>(R.id.view_pager)
        var next2=view.findViewById<TextView>(R.id.next2)

        next2.setOnClickListener {
            view_pager?.currentItem=2
        }

        return view
    }


}