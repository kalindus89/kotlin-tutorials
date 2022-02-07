package com.kotlin.tutorialone.mvvm_retrofit.views.second_fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.tutorialone.R
import com.kotlin.tutorialone.databinding.RecyclerviewDisneyMovieBinding
import com.kotlin.tutorialone.mvvm_retrofit.models.ModelResponseDisney
import com.kotlin.tutorialone.mvvm_retrofit.views.RecyclerClickListener

class MoviesDisneyRecyclerAdapter(private val moviesDisney: List<ModelResponseDisney>, private val listener: RecyclerClickListener) :
    RecyclerView.Adapter<MoviesDisneyRecyclerAdapter.MovieViewHolder>() {


    inner class MovieViewHolder(val recyclerviewDisneyMovieBinding: RecyclerviewDisneyMovieBinding) :
        RecyclerView.ViewHolder(recyclerviewDisneyMovieBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MovieViewHolder(

        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.recyclerview_disney_movie,
            parent, false
        )
    )

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        holder.recyclerviewDisneyMovieBinding.modelResponseDisney=moviesDisney[position]

        holder.recyclerviewDisneyMovieBinding.buttonBook.setOnClickListener{
            listener.onRecyclerItemClickDisney(holder.recyclerviewDisneyMovieBinding.buttonBook,moviesDisney[position])
        } // implement in fragment and interface
        holder.recyclerviewDisneyMovieBinding.textViewTitle.setOnClickListener {
            listener.onRecyclerItemClickDisney(holder.recyclerviewDisneyMovieBinding.textViewTitle,moviesDisney[position])
        }

    }

    override fun getItemCount(): Int {
        return moviesDisney.size
    }
}