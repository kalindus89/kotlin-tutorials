package com.kotlin.tutorialone.mvvm_full_tutorial.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kotlin.tutorialone.mvvm_full_tutorial.data.db.entities.CURRENT_USER_ID
import com.kotlin.tutorialone.mvvm_full_tutorial.data.db.entities.Quotes
import com.kotlin.tutorialone.mvvm_full_tutorial.data.db.entities.UserEntity

@Dao
interface QuoteDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE) //OnConflictStrategy overwrite the save user in conflict
    fun saveAllQuotes(quotes: List<Quotes>) : Long // return long value after inserting success

    @Query("SELECT * FROM quotes")
    fun getQuotes(): LiveData<List<Quotes>>

}