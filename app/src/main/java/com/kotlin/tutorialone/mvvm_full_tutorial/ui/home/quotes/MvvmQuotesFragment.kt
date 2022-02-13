package com.kotlin.tutorialone.mvvm_full_tutorial.ui.home.quotes

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.tutorialone.R

class MvvmQuotesFragment : Fragment() {

    companion object {
        fun newInstance() = MvvmQuotesFragment()
    }

    private lateinit var viewModel: MvvmQuotesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.mvvm_quotes_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MvvmQuotesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}