package com.example.myapplication.widget.ten.tenone

import android.content.Context
import android.graphics.*
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RectShape
import android.util.AttributeSet
import android.view.View
import com.example.myapplication.R

class ShapeShaderView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var mShapeDrawable: ShapeDrawable? = null

    init {
        setLayerType(LAYER_TYPE_HARDWARE,null)
        mShapeDrawable = ShapeDrawable(RectShape())
        mShapeDrawable?.bounds = Rect(100, 100, 500, 1000)
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.timg)
        val bitmapShader = BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        mShapeDrawable?.paint?.color = Color.RED
        mShapeDrawable?.paint?.shader = bitmapShader
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        mShapeDrawable?.draw(canvas!!)
    }
}