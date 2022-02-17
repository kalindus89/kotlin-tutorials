package com.kotlin.tutorialone.mvvm_full_tutorial.ui.home.quotes

import android.os.Build
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import com.kotlin.tutorialone.R
import com.kotlin.tutorialone.mvvm_full_tutorial.data.db.AppDatabase
import com.kotlin.tutorialone.mvvm_full_tutorial.data.network.MyApi
import com.kotlin.tutorialone.mvvm_full_tutorial.data.network.NetworkConnectorInterceptor
import com.kotlin.tutorialone.mvvm_full_tutorial.data.preferences.PreferenceProvider
import com.kotlin.tutorialone.mvvm_full_tutorial.data.repository.QuotesRepository
import com.kotlin.tutorialone.mvvm_full_tutorial.data.repository.UserRepository
import com.kotlin.tutorialone.mvvm_full_tutorial.ui.home.profile.ProfileViewModelFactory
import com.kotlin.tutorialone.mvvm_full_tutorial.utils.Coroutiness
import com.kotlin.tutorialone.mvvm_full_tutorial.utils.showToast

class MvvmQuotesFragment : Fragment() {


    private lateinit var viewModel: MvvmQuotesViewModel

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        val networkConnectorInterceptor= NetworkConnectorInterceptor(requireContext())
        val api = MyApi(networkConnectorInterceptor)
        val db = AppDatabase(requireContext())
        val pref = PreferenceProvider(requireContext())
        val repository = QuotesRepository(api,db,pref)
        val factory= QuotesViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(MvvmQuotesViewModel::class.java)

        Coroutiness.main {
           val quotes= viewModel.quotes.await()
            quotes.observe(viewLifecycleOwner, Observer {

                context?.showToast(it.size.toString())
            })
        }

        return inflater.inflate(R.layout.mvvm_quotes_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // TODO: Use the ViewModel
    }

}