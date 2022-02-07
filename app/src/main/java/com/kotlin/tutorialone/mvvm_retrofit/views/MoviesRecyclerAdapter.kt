package com.kotlin.tutorialone.mvvm_retrofit.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.tutorialone.R
import com.kotlin.tutorialone.databinding.RecyclerviewMovieBinding
import com.kotlin.tutorialone.mvvm_retrofit.models.ModelResponse

class MoviesRecyclerAdapter(private val movies: List<ModelResponse>, private val listener: RecyclerClickListener) :
    RecyclerView.Adapter<MoviesRecyclerAdapter.MovieViewHolder>() {


    inner class MovieViewHolder(val recyclerviewMovieBinding: RecyclerviewMovieBinding) :
        RecyclerView.ViewHolder(recyclerviewMovieBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MovieViewHolder(

        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.recyclerview_movie,
            parent, false
        )
    )

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        holder.recyclerviewMovieBinding.modelResponse=movies[position]

        holder.recyclerviewMovieBinding.buttonBook.setOnClickListener{
            listener.onRecyclerItemClick(holder.recyclerviewMovieBinding.buttonBook,movies[position])
        } // implement in fragment and interface
        holder.recyclerviewMovieBinding.textViewTitle.setOnClickListener {
            listener.onRecyclerItemClick(holder.recyclerviewMovieBinding.textViewTitle,movies[position])
        }

    }

    override fun getItemCount(): Int {
       return movies.size
    }
}

