package com.example.myapplication.ui.main

import android.view.ViewGroup
import androidx.leanback.widget.ImageCardView
import androidx.leanback.widget.Presenter
import com.example.myapplication.ui.commons.loadUrl


class CardPresenter : Presenter(){
    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val cardView = ImageCardView(parent.context).apply {
            isFocusable = true
            isFocusableInTouchMode = true
            setMainImageDimensions(176,313)
        }


        return ViewHolder(cardView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, item: Any) {
        val pelicula = item as Movie
        with (viewHolder.view as ImageCardView){
            titleText = pelicula.title
            contentText = pelicula.year.toString()
            mainImageView.loadUrl(pelicula.poster)
        }


    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder) {
        with (viewHolder.view as ImageCardView){
            mainImage = null
        }
    }


}