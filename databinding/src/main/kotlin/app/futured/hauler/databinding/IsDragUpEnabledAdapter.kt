package app.futured.hauler.databinding

import androidx.databinding.BindingAdapter
import app.futured.hauler.HaulerView

@BindingAdapter("app:isDragUpEnabled")
fun HaulerView.isDragUpEnabled(isDragUpEnabled: Boolean) {
    this.setDragUpEnabled(isDragUpEnabled)
}
