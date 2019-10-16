package com.example.myapplication.widget.ten.tenone

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RectShape
import android.util.AttributeSet
import android.view.View

/*
* ShapeDrawable 的 setBounds 方法位置对应的是当前控件的坐标不是整个屏幕的坐标
* ShapeDrawable 是自带画笔的 当更改Paint的内容时自动更新drawable
* paint.setShader  shader 是从当前画布左上角开始绘图的所以当ShapeDrawable 的Paint 调用Shader时
* shapeDrawable所在区域的左上角开始绘制的
* setAlpha 设置透明度
* setColorFilter
* setIntrinsicHeight设置默认高度
* setIntrinsicWidth 设置默认宽度
* setPadding  设置边距
* */
class RectShapeView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var mShapeDrawable: ShapeDrawable? = null

    init {
        setLayerType(LAYER_TYPE_HARDWARE,null)
        mShapeDrawable = ShapeDrawable(RectShape())
        mShapeDrawable?.setBounds(0, 0, 300, 100)
        mShapeDrawable?.paint?.color = Color.RED
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        mShapeDrawable?.draw(canvas!!)
    }


}