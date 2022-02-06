package com.kotlin.tutorialone.navigation_componet_two.on_boarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.kotlin.tutorialone.R
import com.kotlin.tutorialone.navigation_componet_two.on_boarding.fragments_screens.FirstFragmentScreen
import com.kotlin.tutorialone.navigation_componet_two.on_boarding.fragments_screens.SecondFragmentScreen
import com.kotlin.tutorialone.navigation_componet_two.on_boarding.fragments_screens.ThirdFragmentScreen


class ViewpagerFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_viewpager, container, false)

        val fragmentLists = arrayListOf<Fragment>(FirstFragmentScreen(),SecondFragmentScreen(),ThirdFragmentScreen())

        val viewPagerAdapter =ViewPagerAdapter(fragmentLists,requireActivity().supportFragmentManager,lifecycle)

        val view_pager=view.findViewById<ViewPager2>(R.id.view_pager)

        view_pager.adapter=viewPagerAdapter


        return view
    }


}