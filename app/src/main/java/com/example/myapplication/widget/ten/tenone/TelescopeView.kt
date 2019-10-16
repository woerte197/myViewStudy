package com.example.myapplication.widget.ten.tenone

import android.content.Context
import android.graphics.*
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.example.myapplication.R

/*
* 放大镜思路
* 首先根据手指位置计算圆心，半径画圆
* */
class TelescopeView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var shapeDrawable: ShapeDrawable? = null
    private var mX: Float = 0f
    private var mY: Float = 0f
    private var mMatrix: Matrix = Matrix()
    private var mRadius = 40f
    private var mMultiple = 3
    private var mBitmap: Bitmap? = null
    private var mPaint = Paint()


    init {
        setLayerType(LAYER_TYPE_HARDWARE, null)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        mX = event?.x!!
        mY = event?.y!!
        mMatrix.setTranslate(mRadius - mX * mMultiple, mRadius - mY * mMultiple)
        shapeDrawable?.paint?.shader?.setLocalMatrix(mMatrix)

        shapeDrawable?.setBounds(
            (mX - mRadius).toInt(),
            (mY - mRadius).toInt(),
            (mX + mRadius).toInt(),
            (mY + mRadius).toInt()
        )
        invalidate()
        return true


    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        if (mBitmap == null) {
            val tBitmap = BitmapFactory.decodeResource(resources, R.drawable.timg)
            mBitmap = Bitmap.createScaledBitmap(tBitmap!!, width, height, false)
            val bitmapShader = BitmapShader(
                Bitmap.createScaledBitmap(
                    mBitmap!!,
                    mBitmap!!.width * mMultiple,
                    mBitmap!!.height * mMultiple,
                    true
                ), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP
            )
            shapeDrawable = ShapeDrawable(OvalShape())
            shapeDrawable?.paint?.shader = bitmapShader
            shapeDrawable?.setBounds(0, 0, (mRadius * 2).toInt(), (mRadius * 2).toInt())
        }
        canvas?.drawBitmap(mBitmap!!, 0f, 0f, null)
        shapeDrawable?.draw(canvas!!)


    }

}