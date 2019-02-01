package com.thefuntasty.hauler.databinding

import androidx.databinding.BindingAdapter
import com.thefuntasty.hauler.HaulerView

@BindingAdapter("app:isDragUpEnabled")
fun HaulerView.isDragUpEnabled(isDragUpEnabled: Boolean) {
    this.setDragUpEnabled(isDragUpEnabled)
}
