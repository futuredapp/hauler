package com.thefuntasty.hauler.databinding

import androidx.databinding.BindingAdapter
import com.thefuntasty.hauler.HaulerView
import com.thefuntasty.hauler.OnDragDismissedListener
import com.thefuntasty.hauler.setOnDragDismissedListener

@BindingAdapter("app:onDragDismissedListener")
fun HaulerView.setOnDragDismissedListener(listener: OnDragDismissedListener) {
    this.setOnDragDismissedListener { listener.onDismissed(it) }
}
