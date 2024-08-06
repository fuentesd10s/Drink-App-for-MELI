package com.fuentescreations.drinkappformeli.utils

import android.view.View
import android.widget.ImageView
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.bumptech.glide.Glide

fun ImageView.loadImage(url: String?) =
    Glide.with(this)
        .load(url)
        .into(this)

fun View.setToVisible() { this.isVisible = true }

fun View.setToInvisible() { this.isInvisible = true }

fun View.setToGone() { this.isVisible = false }