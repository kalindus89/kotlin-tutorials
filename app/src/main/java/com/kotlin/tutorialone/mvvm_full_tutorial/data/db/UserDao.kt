package com.kotlin.tutorialone.mvvm_full_tutorial.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kotlin.tutorialone.mvvm_full_tutorial.data.db.entities.CURRENT_USER_ID
import com.kotlin.tutorialone.mvvm_full_tutorial.data.db.entities.UserEntity

//dao where all the database operations are happening
@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE) //OnConflictStrategy overwrite the save user in conflict
    suspend fun insert_data(user:UserEntity) : Long // return long value after inserting success

    @Query("SELECT * FROM userentity where uid=$CURRENT_USER_ID")
    fun getUser():LiveData<UserEntity>

}