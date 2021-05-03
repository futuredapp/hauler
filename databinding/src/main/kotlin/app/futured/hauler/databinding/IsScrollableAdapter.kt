package app.futured.hauler.databinding

import androidx.databinding.BindingAdapter
import app.futured.hauler.LockableNestedScrollView

@BindingAdapter("app:isScrollable")
fun LockableNestedScrollView.isScrollable(isScrollable: Boolean) {
    setScrollEnabled(isScrollable)
}
