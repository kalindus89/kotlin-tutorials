package com.kotlin.tutorialone.mvvm_retrofit

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.tutorialone.R

class MovieListFragment : Fragment() {

    private lateinit var factory: MoviesViewModelFactory
    private lateinit var viewModel: MovieListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view= inflater.inflate(R.layout.movie_list_fragment, container, false)

        val api =MovieApi()
        val repository =MoviesRepository(api)
        factory=MoviesViewModelFactory(repository)
        viewModel = ViewModelProvider(this,factory).get(MovieListViewModel::class.java)
        viewModel.getMovies()
        return view;
    }


}