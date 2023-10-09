package com.example.views

import android.annotation.SuppressLint
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
    private var rectangle: RectF? = null
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
        setPaintSettings()
    }

    @SuppressLint("DrawAllocation")
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val halfStrokeWidth = strokeWidth / 2
        rectangle = RectF(
            10F + halfStrokeWidth,
            10F + halfStrokeWidth,
            (measuredWidth - 10.0).toFloat() - halfStrokeWidth,
            (measuredHeight - 10.0).toFloat() - halfStrokeWidth
        )
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        rectangle?.let {
            canvas?.drawRoundRect(it, roundingRadius, roundingRadius, paint)
        }
    }

    private fun setPaintSettings() {
        paint.apply {
            style = Paint.Style.STROKE
            color = strokeColor
            strokeWidth = strokeWidth
        }
    }
}