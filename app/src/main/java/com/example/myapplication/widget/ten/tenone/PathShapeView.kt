package com.example.myapplication.widget.ten.tenone

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Path
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.PathShape
import android.util.AttributeSet
import android.view.View

class PathShapeView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var pathShapeView: ShapeDrawable? = null

    init {
        val path = Path()
        path.moveTo(100f,100f)
        path.lineTo(150f,100f)
        path.lineTo(150f,150f)
        path.lineTo(100f,150f)
        path.close()
        pathShapeView = ShapeDrawable(PathShape(path, 200f,100f))
        pathShapeView?.setBounds(0, 0, 100, 100)
        pathShapeView?.paint?.color = Color.RED
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        pathShapeView?.draw(canvas!!)
    }


}