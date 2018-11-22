package com.thefuntasty.hauler.databinding

import androidx.databinding.BindingAdapter
import com.thefuntasty.hauler.HaulerView

@BindingAdapter("app:onDragDismissedListener")
fun HaulerView.setOnDragDismissedListener(listener: Runnable) {
    this.setOnDragDismissedListener { listener.run() }
}
