package app.futured.haulersample.draggable.advanced

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatTextView
import app.futured.hauler.LockableNestedScrollView

class IgnoredAreaView @kotlin.jvm.JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

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
