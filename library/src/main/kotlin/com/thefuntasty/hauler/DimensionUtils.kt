package com.thefuntasty.hauler

import android.content.Context

internal fun pxFromDp(context: Context, dp: Float): Float {
    return dp * context.resources.displayMetrics.density
}
