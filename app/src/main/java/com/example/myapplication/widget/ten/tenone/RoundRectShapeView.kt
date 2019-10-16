package com.example.myapplication.widget.ten.tenone

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.RectF
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.ArcShape
import android.graphics.drawable.shapes.OvalShape
import android.graphics.drawable.shapes.RoundRectShape
import android.util.AttributeSet
import android.view.View

/*
* RoundRectShape 参数 第一个参数是以个外面圆角数组 长度为8 每两个指定一个角 分别对应左上角 右上角 右小角 左下角
* 第二个参数是一个矩形
* 第三个参数是内角读书同第一个参数
* */
class RoundRectShapeView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var arcShapeView: ShapeDrawable? = null
    companion object{
        val mOutRadius = floatArrayOf(12f,12f,12f,12f,0f,0f,0f,0f)
    }

    init {
        arcShapeView = ShapeDrawable(RoundRectShape(mOutRadius, RectF(0f,0f,100f,100f), mOutRadius))
        arcShapeView?.setBounds(0, 0, 100, 100)
        arcShapeView?.paint?.color = Color.RED
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        arcShapeView?.draw(canvas!!)
    }


}