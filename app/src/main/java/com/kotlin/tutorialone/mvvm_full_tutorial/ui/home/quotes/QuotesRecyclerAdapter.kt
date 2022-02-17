package com.kotlin.tutorialone.mvvm_full_tutorial.ui.home.quotes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.tutorialone.R
import com.kotlin.tutorialone.databinding.ItemQuoteBinding
import com.kotlin.tutorialone.mvvm_full_tutorial.data.db.entities.Quotes


class QuotesRecyclerAdapter(private val quotesList: List<Quotes>) :
    RecyclerView.Adapter<QuotesRecyclerAdapter.QuotesViewHolder>() {


    inner class QuotesViewHolder(val itemQuoteBinding: ItemQuoteBinding) :
        RecyclerView.ViewHolder(itemQuoteBinding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int )= QuotesViewHolder (

        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_quote,
            parent, false
        )
    )


    override fun onBindViewHolder(holder: QuotesViewHolder, position: Int) {
     //   holder.recyclerviewMovieBinding.modelResponse=movies[position]
        holder.itemQuoteBinding.quoteRes=quotesList[position]
    }



    override fun getItemCount(): Int {
        return quotesList.size
    }


}