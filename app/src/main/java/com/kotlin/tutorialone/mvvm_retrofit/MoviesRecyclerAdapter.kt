package com.kotlin.tutorialone.mvvm_retrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.tutorialone.R
import com.kotlin.tutorialone.databinding.RecyclerviewMovieBinding

class MoviesRecyclerAdapter(private val movies: List<ModelResponse>) :
    RecyclerView.Adapter<MoviesRecyclerAdapter.MovieViewHolder>() {


    inner class MovieViewHolder(val viewHolder: RecyclerviewMovieBinding) :
        RecyclerView.ViewHolder(viewHolder.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MovieViewHolder(

        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.recyclerview_movie,
            parent, false
        )
    )

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
           holder.viewHolder.modelResponse=movies[position]
    }

    override fun getItemCount(): Int {
       return movies.size
    }
}