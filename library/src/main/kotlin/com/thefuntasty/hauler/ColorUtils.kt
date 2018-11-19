package com.thefuntasty.hauler

import androidx.annotation.CheckResult
import androidx.annotation.ColorInt
import androidx.annotation.IntRange

object ColorUtils {

    @CheckResult
    @ColorInt
    fun modifyAlpha(@ColorInt color: Int, @IntRange(from = 0, to = 255) alpha: Int): Int =
        color and 0x00ffffff or (alpha shl 24)
}
