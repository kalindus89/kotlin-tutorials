package com.kotlin.tutorialone.mvvm_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kotlin.tutorialone.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MovieMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_movie_main)

        val repository = MoviesRepository(MovieApi())

        GlobalScope.launch (Dispatchers.Main){ // because we used coroutines

            val movies =   repository.getMovies()

            Toast.makeText(this@MovieMainActivity, movies.toString(), Toast.LENGTH_SHORT).show()

        }


    }
}