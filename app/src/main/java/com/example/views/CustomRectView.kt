package com.example.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class CustomRectView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defaultStyle: Int = 0
) : View(context, attrs, defaultStyle) {

    private val paint = Paint()
    private val rectangle = RectF(200F, 100F, 880F, 300F)
    private val strokeWidth: Float
    private val strokeColor: Int
    private val roundingRadius: Float

    init {
        context.theme.obtainStyledAttributes(
            attrs, R.styleable.CustomRectView, 0, 0
        ).apply {
            try {
                strokeWidth = getDimension(R.styleable.CustomRectView_strokeWidth, 0F)
                strokeColor = getColor(R.styleable.CustomRectView_strokeColor, 0)
                roundingRadius = getDimension(R.styleable.CustomRectView_roundingRadius, 0F)
            } finally {
                recycle()
            }

        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        setPaintSettings()
        canvas?.drawRoundRect(rectangle, roundingRadius, roundingRadius, paint)
    }

    private fun setPaintSettings() {
        paint.apply {
            style = Paint.Style.FILL
            color = strokeColor
            strokeWidth = strokeWidth
        }
    }
}