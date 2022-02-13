package com.kotlin.tutorialone.mvvm_full_tutorial.ui.home.profile

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.kotlin.tutorialone.R
import com.kotlin.tutorialone.databinding.MvvmProfileFragmentBinding
import com.kotlin.tutorialone.mvvm_full_tutorial.data.db.AppDatabase
import com.kotlin.tutorialone.mvvm_full_tutorial.data.network.MyApi
import com.kotlin.tutorialone.mvvm_full_tutorial.data.network.NetworkConnectorInterceptor
import com.kotlin.tutorialone.mvvm_full_tutorial.data.repository.UserRepository
import com.kotlin.tutorialone.mvvm_full_tutorial.ui.auth.AuthViewModelFactory

class MvvmProfileFragment : Fragment() {


    private lateinit var viewModel: MvvmProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
      //  val view= inflater.inflate(R.layout.mvvm_profile_fragment, container, false)

        val networkConnectorInterceptor= NetworkConnectorInterceptor(requireContext())
        val api = MyApi(networkConnectorInterceptor)
        val db = AppDatabase(requireContext())
        val repository = UserRepository(api,db)
        val factory= ProfileViewModelFactory(repository)


        val binding :MvvmProfileFragmentBinding = DataBindingUtil.inflate(inflater,R.layout.mvvm_profile_fragment,container,false) //inflate for fragment
        viewModel = ViewModelProvider(this,factory).get(MvvmProfileViewModel::class.java)
       binding.viewModel=viewModel
        binding.lifecycleOwner=this

        return binding.root
    }


}