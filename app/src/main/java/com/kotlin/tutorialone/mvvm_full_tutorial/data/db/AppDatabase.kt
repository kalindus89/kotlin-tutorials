package com.kotlin.tutorialone.mvvm_full_tutorial.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kotlin.tutorialone.mvvm_full_tutorial.data.db.entities.UserEntity


// check and create the database

@Database(
    entities = [UserEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getUserDao():UserDao

    companion object{

        @Volatile // Volatile - immediately visible to all the threads
        private var instance:AppDatabase?=null

        private val LOCK = Any()

        operator fun invoke(context:Context)= instance?: synchronized(LOCK){
            instance?:buildDatabase(context).also {
                instance=it
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
            AppDatabase::class.java,
            "UserDatabase" //databasename
            ).build()

    }
}