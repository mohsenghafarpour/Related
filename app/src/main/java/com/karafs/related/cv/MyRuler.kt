package com.karafs.related.cv

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.TypedValue
import android.view.View


class MyRuler(context: Context?) : View(context) {

    private val mmPaint = Paint().apply {
        isAntiAlias = true
        color = Color.BLACK
        strokeWidth = 1F
    }

    private val cmPaint = Paint().apply {
        isAntiAlias = true
        color = Color.RED
        strokeWidth = 1F
        textSize = 32F
    }


    var isVertical = false
        set(value) {
            if (value != field) {
                field = value
                invalidate()
            }
        }

    var isInch = false
        set(value) {
            if (value != field) {
                field = value
                invalidate()
            }
        }


    // Called when the view should render its content.
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val dimension = if (isVertical)
            resources.displayMetrics.heightPixels
        else
            resources.displayMetrics.widthPixels

        val px = TypedValue.applyDimension(
            if (isInch) TypedValue.COMPLEX_UNIT_IN else TypedValue.COMPLEX_UNIT_MM,
            if (isInch) 0.1f else 1f,
            resources.displayMetrics
        )

        var i = 0
        while (i * px < dimension) {
            val x = i * px

            val sx = if (isVertical) 0f else x
            val ex = if (isVertical) if (i % 10 == 0) 40f else 20f else x
            val sy = if (isVertical) x else 0f
            val ey = if (isVertical) x else if (i % 10 == 0) 40f else 20f

            val stx = if (isVertical) sx + 60f else sx
            val sty = if (isVertical) sy else sy + 80f

            if (i % 10 == 0) {
                canvas?.drawLine(sx, sy, ex, ey, cmPaint)
                canvas?.drawText(if (isInch) "${i / 10} in " else "${i / 10} cm", stx, sty, cmPaint)
            } else
                canvas?.drawLine(sx, sy, ex, ey, mmPaint)
            i++
        }
    }
}