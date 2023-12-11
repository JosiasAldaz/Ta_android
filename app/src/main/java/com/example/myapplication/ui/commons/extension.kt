package com.example.myapplication.ui.commons

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadUrl(url:String){
    Glide
        .with(this)
        .load(url)
        .into(this)
}