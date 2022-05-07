package com.example.xoii.extensions

import android.content.res.Resources
import android.util.TypedValue

val Number.toPx
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        Resources.getSystem().displayMetrics
    )