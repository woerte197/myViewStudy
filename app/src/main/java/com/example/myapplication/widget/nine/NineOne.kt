package com.example.myapplication.widget.nine

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/*
*
* 获取canvas对象的方法
* 第一种 重写onDraw() dispatchDraw()函数来获取
* 第二种 使用bitmap创建
* 第三种 使用SurfaceView时,当调用SurfaceHolder.lockCanvas()函数时，也会创建Canvas对象
* */

class NineOne @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var mBitmapCanvas: Canvas? = null
    private var mPaint: Paint? = null
    private var bitmap: Bitmap? = null


    init {
        mPaint = Paint()
        mPaint?.color = Color.RED
        //通过bitmap 构建canvas
        //在这个 mBitmapCanvas 上的绘图都都将存在当前bitmap上，要想在当前view上现实出来需要在onDraw上的
        //mBitmapCanvas 重新进行绘制
        bitmap = Bitmap.createBitmap(1000, 500, Bitmap.Config.ARGB_8888)
        mBitmapCanvas = Canvas(bitmap!!)

    }


    //一般在自定义View时我们都会重写onDraw() dispatchDraw() 函数
    //这两个函数中都有一个canvas 对象 用这个对象绘图 会直接反应在当前View上
    //onDraw 函数用于绘制自身视图 dispatchDraw() 用于绘制子视图
    //无论在View中还是ViewGroup中调用的顺序都是onDraw()->dispatchDraw()
    //但是在ViewGroup中当他有背景的时候就调用onDraw否则就会跳过onDraw直接调用dispatchDraw()
    //所以如果在viewGroup中一般重写dispatchDraw()函数来进行绘图
    //在View中，onDraw() 和 dispatchDraw()都会调用所以把绘图代码放在任何其中一个都会有效果
    //但由于dispatchDraw()是用来绘制子视图的所以常常在onDraw()进行绘制
    //总结：绘制view时重写onDraw 在重写viewGroup时重写dispatchDraw()函数
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        mPaint?.textSize=50f
        mBitmapCanvas?.drawText("您好欢迎来到德莱联盟",100f,100f,mPaint!!)
        canvas?.drawBitmap(bitmap!!, 0f, 0f, mPaint)

    }

    override fun dispatchDraw(canvas: Canvas?) {
        super.dispatchDraw(canvas)
    }


}