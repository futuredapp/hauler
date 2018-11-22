package com.thefuntasty.hauler.databinding

import androidx.databinding.BindingAdapter
import com.thefuntasty.hauler.HaulerView

@BindingAdapter("app:isDragEnabled")
fun HaulerView.isDragEnabled(isDragEnabled: Boolean) {
    this.setDragEnabled(isDragEnabled)
}
