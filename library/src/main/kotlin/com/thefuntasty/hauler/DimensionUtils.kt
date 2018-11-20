package com.thefuntasty.hauler

import android.content.Context

fun pxFromDp(context: Context, dp: Float): Float {
    return dp * context.resources.displayMetrics.density
}
