package com.kotlin.tutorialone.navigation_components

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.kotlin.tutorialone.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment() {



    val getPassedArgumentValues : SecondFragmentArgs by navArgs() // val type.. get the value passed from fragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_second, container, false)
        var txt = view.findViewById<TextView>(R.id.txt2)

        txt.text=getPassedArgumentValues.testNumber.toString()

        txt.setOnClickListener {

            Navigation.findNavController(view).navigate(R.id.to_thirdFragmentFrom2)

        }
        return view
    }

}