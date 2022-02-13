package com.kotlin.tutorialone.mvvm_full_tutorial.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object Coroutiness { // object is link static in java

    fun main(work:suspend (()->Unit))=
        CoroutineScope(Dispatchers.Main).launch {
            work()
        }


    fun io(work:suspend (()->Unit))=
        CoroutineScope(Dispatchers.IO).launch {
            work()
        }
}