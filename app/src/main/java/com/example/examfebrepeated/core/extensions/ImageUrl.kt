package com.example.examfebrepeated.core.extensions

import android.widget.ImageView
import coil3.load
import coil3.request.crossfade
import coil3.request.error
import com.example.examfebrepeated.R

fun ImageView.loadUrl(url: String?) {
    this.load(url) {
        error(R.drawable.rfoto)
        crossfade(true)
        crossfade(500)
    }
}