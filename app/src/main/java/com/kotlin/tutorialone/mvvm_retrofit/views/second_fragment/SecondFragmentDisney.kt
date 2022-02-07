package com.kotlin.tutorialone.mvvm_retrofit.views.second_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.tutorialone.R
import com.kotlin.tutorialone.mvvm_retrofit.MovieApi
import com.kotlin.tutorialone.mvvm_retrofit.models.ModelResponse
import com.kotlin.tutorialone.mvvm_retrofit.models.ModelResponseDisney
import com.kotlin.tutorialone.mvvm_retrofit.repository.MoviesRepository
import com.kotlin.tutorialone.mvvm_retrofit.view_model.MovieListViewModel
import com.kotlin.tutorialone.mvvm_retrofit.view_model.MoviesViewModelFactory
import com.kotlin.tutorialone.mvvm_retrofit.views.MoviesRecyclerAdapter
import com.kotlin.tutorialone.mvvm_retrofit.views.RecyclerClickListener

class SecondFragmentDisney : Fragment() , RecyclerClickListener {


    private lateinit var factory: MoviesViewModelFactory
    private lateinit var viewModel: MovieListViewModel
    private lateinit var recyclerViewDisney: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        var view= inflater.inflate(R.layout.fragment_second_disney, container, false)

        recyclerViewDisney=view.findViewById<RecyclerView>(R.id.recyclerViewDisney)

        val api = MovieApi()
        val repository = MoviesRepository(api)
        factory= MoviesViewModelFactory(repository)
        viewModel = ViewModelProvider(this,factory).get(MovieListViewModel::class.java)
        viewModel.getDisneyMovies()
        viewModel.moviesDisneyLive.observe(viewLifecycleOwner, Observer { moviesDisney->
            recyclerViewDisney.also {
                it.layoutManager= LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter= MoviesDisneyRecyclerAdapter(moviesDisney,this)

            }
        })

        return view
    }

    override fun onRecyclerItemClick(view: View, movie: ModelResponse) {
        TODO("Not yet implemented")
    }

    override fun onRecyclerItemClickDisney(view: View, movie: ModelResponseDisney) {
    //    Toast.makeText(requireContext(), movie.name, Toast.LENGTH_SHORT).show()
        Navigation.findNavController(view).navigate(R.id.action_secondFragmentDisney_to_movieListFragment)

    }


}