package app.futured.hauler

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.core.widget.NestedScrollView

class LockableNestedScrollView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : NestedScrollView(context, attrs, defStyleAttr) {

    private var isScrollable = true

    fun setScrollEnabled(isScrollEnabled: Boolean) {
        isScrollable = isScrollEnabled
    }

    @Suppress("ClickableViewAccessibility")
    override fun onTouchEvent(ev: MotionEvent): Boolean = when (ev.action) {
        MotionEvent.ACTION_DOWN ->
            isScrollable && super.onTouchEvent(ev)
        else ->
            super.onTouchEvent(ev)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent) = isScrollable && super.onInterceptTouchEvent(ev)
}
