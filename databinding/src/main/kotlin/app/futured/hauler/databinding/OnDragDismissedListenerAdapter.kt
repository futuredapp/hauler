package app.futured.hauler.databinding

import androidx.databinding.BindingAdapter
import app.futured.hauler.HaulerView
import app.futured.hauler.OnDragDismissedListener
import app.futured.hauler.setOnDragDismissedListener

@BindingAdapter("app:onDragDismissedListener")
fun HaulerView.setOnDragDismissedListener(listener: OnDragDismissedListener) {
    this.setOnDragDismissedListener { listener.onDismissed(it) }
}
