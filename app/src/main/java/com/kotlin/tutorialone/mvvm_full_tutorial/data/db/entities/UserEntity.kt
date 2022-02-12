package com.kotlin.tutorialone.mvvm_full_tutorial.data.db.entities
import androidx.room.Entity
import androidx.room.PrimaryKey


const val CURRENT_USER_ID = 0


//Entity class represent the table of the database
@Entity
data class UserEntity (
    val user_id:String?=null,
    val email_user:String?=null,
    val name_user:String?=null
){
    @PrimaryKey(autoGenerate = false)
    var uid: Int = CURRENT_USER_ID
}
