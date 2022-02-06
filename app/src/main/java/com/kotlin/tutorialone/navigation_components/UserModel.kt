package com.kotlin.tutorialone.navigation_components

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserModel(var fName:String, var lname:String): Parcelable



