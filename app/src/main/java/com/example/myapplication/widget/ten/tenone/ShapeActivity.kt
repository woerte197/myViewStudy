package com.example.myapplication.widget.ten.tenone

import android.graphics.BitmapFactory
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_shape.*

/*
* ShapeDrawable 有两个构造函数
* ShapeDrawable()
* ShapeDrawable(Shape s)
* 使用第一个构造函数需要额外使用setShape方法 所以直接使用第二个构造函数
* Shape 是一个抽象类，有以下实例
* RectShape 构造一个矩形Shape
* AreShape  构造一个扇形Shape
* OvalShape 构造一个椭圆Shape
* RoundRectShape 构造一个圆角矩形Shape 可带有镂空矩形效果
* PathShape:构造一个可根据枯井绘制的Shape
* */
class ShapeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shape)
        mButton.setOnClickListener {
            val drawable = mChangeBt.background as GradientDrawable
            drawable.cornerRadius = 20f
        }
//        val drawable = CustomDrawable(BitmapFactory.decodeResource(resources, R.drawable.timg))
//        mTestImageView.setImageDrawable(drawable)
        mTestImageView.setImageBitmap(BitmapFactory.decodeResource(resources,R.drawable.timg))
    }
}
