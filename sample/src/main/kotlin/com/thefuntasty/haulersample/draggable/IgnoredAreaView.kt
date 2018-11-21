package com.thefuntasty.haulersample.draggable

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.TextView
import com.thefuntasty.hauler.LockableNestedScrollView

class IgnoredAreaView @kotlin.jvm.JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : TextView(context, attrs, defStyleAttr) {

    private var parentScrollView: LockableNestedScrollView? = null

    fun setScrollViewParent(parentScrollView: LockableNestedScrollView) {
        this.parentScrollView = parentScrollView
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        return when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                parentScrollView?.setScrollEnabled(false)
                true
            }

            MotionEvent.ACTION_UP -> {
                parentScrollView?.setScrollEnabled(true)
                true
            }
            else -> false
        }
    }
}
