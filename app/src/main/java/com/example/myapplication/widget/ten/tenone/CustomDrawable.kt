package com.example.myapplication.widget.ten.tenone

import android.graphics.*
import android.graphics.drawable.Drawable

/*
* draw()函数 与view函数类似
* setAlpha（）与  setColorFilter()函数将参数传给对应的paint
*
* */
class CustomDrawable(var mBitmap: Bitmap) : Drawable() {
    private var mPaint: Paint? = null
    private var mBounds: RectF? = null
    private var mBitmapShader:BitmapShader? = null

    init {
        mPaint = Paint()
    }

    override fun draw(canvas: Canvas) {
      canvas.drawRoundRect(mBounds!!,100f,100f,mPaint!!)

    }

    override fun setAlpha(alpha: Int) {
        mPaint?.alpha = alpha
    }

    override fun getOpacity(): Int {
        return PixelFormat.TRANSPARENT
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        mPaint?.colorFilter = colorFilter
    }

    override fun getIntrinsicHeight(): Int {
        return mBitmap.height
    }

    override fun getIntrinsicWidth(): Int {
        return mBitmap.width
    }

    override fun setBounds(left: Int, top: Int, right: Int, bottom: Int) {
        super.setBounds(left, top, right, bottom)
        mBitmapShader = BitmapShader(Bitmap.createScaledBitmap(mBitmap, mBitmap.width, mBitmap.height,true),Shader.TileMode.CLAMP,Shader.TileMode.CLAMP)
        mPaint?.shader = mBitmapShader
        mBounds = RectF(left.toFloat(), top.toFloat(), right.toFloat(), bottom.toFloat())
    }

}