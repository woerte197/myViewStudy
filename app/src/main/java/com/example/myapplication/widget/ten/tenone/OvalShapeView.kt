package com.example.myapplication.widget.ten.tenone

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.util.AttributeSet
import android.view.View

class OvalShapeView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var ovalShapeView: ShapeDrawable? = null

    init {
        ovalShapeView = ShapeDrawable(OvalShape())
        ovalShapeView?.setBounds(0, 0, 100, 100)
        ovalShapeView?.paint?.color = Color.RED
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        ovalShapeView?.draw(canvas!!)
    }


}