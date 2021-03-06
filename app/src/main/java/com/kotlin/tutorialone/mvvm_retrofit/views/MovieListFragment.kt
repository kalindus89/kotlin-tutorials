package com.kotlin.tutorialone.mvvm_retrofit.views

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
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

class MovieListFragment : Fragment(), RecyclerClickListener {

    private lateinit var factory: MoviesViewModelFactory
    private lateinit var viewModel: MovieListViewModel
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view= inflater.inflate(R.layout.movie_list_fragment, container, false)

        recyclerView=view.findViewById<RecyclerView>(R.id.recyclerView)

        val api = MovieApi()
        val repository = MoviesRepository(api)
        factory= MoviesViewModelFactory(repository)
        viewModel = ViewModelProvider(this,factory).get(MovieListViewModel::class.java)
        viewModel.getMovies()
        viewModel.moviesLive.observe(viewLifecycleOwner, Observer { movies->
            recyclerView.also {
                it.layoutManager=LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter= MoviesRecyclerAdapter(movies,this)

            }
        })
        return view;
    }

    override fun onRecyclerItemClick(view: View, movie: ModelResponse) {

       // Toast.makeText(requireContext(), movie.name, Toast.LENGTH_SHORT).show()
        Navigation.findNavController(view).navigate(R.id.action_movieListFragment_to_secondFragmentDisney)
    }

    override fun onRecyclerItemClickDisney(view: View, movie: ModelResponseDisney) {
        TODO("Not yet implemented")
    }


}