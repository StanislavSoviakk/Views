package com.example.views

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView

class CustomLinearLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defaultStyle: Int = 0
) : LinearLayout(context, attrs, defaultStyle) {

    private val padding = 4
    private val itemBackgroundColor = Color.parseColor("#000000")
    private val itemTextColor = Color.parseColor("#ffffff")
    private val itemTextSize = 18F

    fun addItem(item: String) {
        val textView = TextView(context)
        textView.apply {
            text = item
            textSize = itemTextSize
            setTextColor(itemTextColor)
            setBackgroundColor(itemBackgroundColor)
            setPadding(padding, padding, padding, padding)
        }

        addView(textView)
    }
}