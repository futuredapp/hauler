package app.futured.hauler.databinding

import androidx.databinding.BindingAdapter
import app.futured.hauler.HaulerView

@BindingAdapter("app:isDragEnabled")
fun HaulerView.isDragEnabled(isDragEnabled: Boolean) {
    this.setDragEnabled(isDragEnabled)
}
