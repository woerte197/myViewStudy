package com.example.myapplication.widget.ten.tentwo

import android.graphics.*
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_ten_two.*

class TenTwoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ten_two)
        var bitmap = BitmapFactory.decodeResource(resources, R.drawable.timg)
        val alphaPaint = Paint()
        val blurMaskFilter = BlurMaskFilter(20f, BlurMaskFilter.Blur.NORMAL)
        alphaPaint.maskFilter = blurMaskFilter
        val offsetXY = IntArray(2)

        val alphaBitmap = bitmap.extractAlpha(alphaPaint, offsetXY)


        var mBitmap = Bitmap.createBitmap(alphaBitmap.width, alphaBitmap.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(mBitmap)
        val paint = Paint()
        paint.color = Color.RED
        canvas.drawBitmap(alphaBitmap, 0f, 0f, paint)
        canvas.drawBitmap(bitmap, -offsetXY[0].toFloat(), -offsetXY[1].toFloat(), null)
        mImageView.setImageBitmap(mBitmap)
    }
}
