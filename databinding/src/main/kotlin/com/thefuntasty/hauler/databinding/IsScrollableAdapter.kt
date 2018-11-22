package com.thefuntasty.hauler.databinding

import androidx.databinding.BindingAdapter
import com.thefuntasty.hauler.LockableNestedScrollView

@BindingAdapter("app:isScrollable")
fun LockableNestedScrollView.isScrollable(isScrollable: Boolean) {
    setScrollEnabled(isScrollable)
}
