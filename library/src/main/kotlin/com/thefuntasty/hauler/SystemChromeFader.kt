package com.thefuntasty.hauler

import android.app.Activity
import android.graphics.Color

class SystemChromeFader(private val activity: Activity) {

    private val statusBarAlpha: Int by lazy { Color.alpha(activity.window.statusBarColor) }

    fun onDrag(elasticOffsetPixels: Float, rawOffset: Float) {
        when {
            elasticOffsetPixels > 0f -> // dragging downward, fade the status bar in proportion
                activity.window.statusBarColor = ColorUtils.modifyAlpha(
                    activity.window
                        .statusBarColor, ((1f - rawOffset) * statusBarAlpha).toInt()
                )
            elasticOffsetPixels == 0f -> {
                activity.window.statusBarColor = ColorUtils.modifyAlpha(
                    activity.window.statusBarColor, statusBarAlpha
                )
            }
        }
    }

    fun onDismiss() {
        // set transparent window bg and transparent navigation bar
        activity.window.decorView.setBackgroundColor(0)
        activity.window.navigationBarColor = ColorUtils.modifyAlpha(activity.window.navigationBarColor, 0)
    }
}
