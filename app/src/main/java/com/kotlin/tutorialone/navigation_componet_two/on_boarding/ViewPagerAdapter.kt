package com.kotlin.tutorialone.navigation_componet_two.on_boarding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(list: ArrayList<Fragment>,fm:FragmentManager, lifeCycle:Lifecycle):FragmentStateAdapter(fm,lifeCycle){

    val fragmentList:ArrayList<Fragment> = list

    override fun getItemCount(): Int {

        return  fragmentList.size

    }


    override fun createFragment(position: Int): Fragment {

        return fragmentList[position]
    }

}