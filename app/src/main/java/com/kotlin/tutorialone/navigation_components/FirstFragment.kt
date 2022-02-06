package com.kotlin.tutorialone.navigation_components

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import com.kotlin.tutorialone.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_first, container, false)

        var txt=view.findViewById<TextView>(R.id.txt1)

        txt.setOnClickListener {

            //https://www.youtube.com/watch?v=vx1-V3HH0IU&list=PLSrm9z4zp4mHilvsfUM3jeCYFV3fTAS3J&index=2
            val action = FirstFragmentDirections.toSecondFragmentFrom1(144) // passing values to 2nd fragments. sync safegard in both gradles
            Navigation.findNavController( view).navigate(action) // no need R.id here because it defines in above line

        }

        return view
    }


}