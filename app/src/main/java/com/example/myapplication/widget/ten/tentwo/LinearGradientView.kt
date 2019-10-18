package com.example.myapplication.widget.ten.tentwo

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class LinearGradientView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var mPaint: Paint? = null
    private var mBitmap: Bitmap? = null
    private var mWidth: Int = 500
    private var mHeight: Int = 300

    init {
        mBitmap = Bitmap.createBitmap(mWidth, mHeight, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(mBitmap!!)
        mPaint = Paint()
        val linearGradient = LinearGradient(
            mWidth / 2.toFloat(),
            0f,
            mWidth / 2.toFloat(),
            mHeight.toFloat(),
            Color.BLACK,
            0x00ffffff,
            Shader.TileMode.CLAMP
        )
        mPaint?.shader = linearGradient
        canvas.drawRect(0f, 0f, mWidth.toFloat(), mHeight.toFloat(), mPaint!!)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawBitmap(mBitmap!!, 0f, 0f, mPaint)
        val paint = Paint()
        paint?.style = Paint.Style.STROKE
        paint?.color = Color.RED
        paint?.strokeWidth = 5f
        canvas?.drawRect(0f, 0f, mWidth.toFloat(), mHeight.toFloat(), paint!!)
    }


}