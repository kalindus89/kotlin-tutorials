package com.kotlin.tutorialone.mvvm_full_tutorial.utils

import android.content.Context
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

fun Context.showToast(message:String){

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

}

fun View.showSnackbar(message:String){

        Snackbar.make(this, message, Snackbar.LENGTH_SHORT).also { snackbar ->
            snackbar.setAction("Ok"){
                snackbar.dismiss()
            }
        }.show()

}