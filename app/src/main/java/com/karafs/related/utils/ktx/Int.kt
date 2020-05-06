package com.karafs.related.utils.ktx

import android.content.res.Resources

val Int.px: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()

