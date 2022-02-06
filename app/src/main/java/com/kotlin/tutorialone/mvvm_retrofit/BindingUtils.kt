package com.kotlin.tutorialone.mvvm_retrofit

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageToLoad")
fun loadingImage(view: ImageView, url:String){
    Glide.with(view).load(url).into(view)

}