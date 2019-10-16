package com.example.myapplication.widget.ten.tenone

import android.content.Context
import android.graphics.*
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.example.myapplication.R

/**
 * Created by qijian on 16/7/10.
 */
class TeleAscopeView : View {
    private var bitmap: Bitmap? = null
    private var drawable: ShapeDrawable? = null
    private val mMatrix: Matrix = Matrix()

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init()
    }


    private fun init() {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val x = event.x.toInt()
        val y = event.y.toInt()
        // 这个位置表示的是，画shader的起始位置
        mMatrix.setTranslate((RADIUS - x * FACTOR).toFloat(), (RADIUS - y * FACTOR).toFloat())
        drawable!!.paint.shader.setLocalMatrix(mMatrix)

        // bounds，就是那个圆的外切矩形
        drawable!!.setBounds(x - RADIUS, y - RADIUS, x + RADIUS, y + RADIUS)
        invalidate()
        return true
    }

     override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

    }

    companion object {
        // 放大镜的半径

        val RADIUS = 80
        // 放大倍数

        val FACTOR = 3
    }

}
