package com.example.myapplication.widget.ten.tenone

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.ArcShape
import android.graphics.drawable.shapes.OvalShape
import android.util.AttributeSet
import android.view.View

class ArcShapeView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var arcShapeView: ShapeDrawable? = null

    init {
        arcShapeView = ShapeDrawable(ArcShape(-30f,120f))
        arcShapeView?.setBounds(0, 0, 100, 100)
        arcShapeView?.paint?.color = Color.RED
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        arcShapeView?.draw(canvas!!)
    }


}