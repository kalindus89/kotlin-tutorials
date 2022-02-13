package com.kotlin.tutorialone.mvvm_full_tutorial.utils

import java.io.IOException

class ApiExceptionss(message:String) : IOException(message)
class NoInternetException(message:String) : IOException(message)