package com.example.myapplication.widget.nine

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/*
* 图层与画布
* saveLayer有两个构造函数
* saveLayer(@Nullable RectF bounds, @Nullable Paint paint) {
        return saveLayer(bounds, paint, ALL_SAVE_FLAG)

  已经废弃
  saveLayer(float left, float top, float right, float bottom, @Nullable Paint paint,
            @Saveflags int saveFlags)
*
* RectF bounds 要保存区域所对应的矩形对象
* 当使用 saveLayer方法时会新生成一个透明画布，在这之间的canvas作用在透明画布上
* 当完成之后统一附着到当前view的canvas 画布上 这时SRC_IN模式就是正确的（当目标图像透明度为0时原图像不显示）
* 如果不调用saveLayer 直接在当前view的canvas 画布上 作图这是由于透明度不是透明所以原图像全部显示出来了
*
* 图层（layer）每次调用canvas.draw方法是都会生成一个透明涂层专门绘制这个图形
*
* 画布（bitmap）每个画布都是一个bitmap 所有的图像都是在这个bitmap上，每次调用canvas.draw方法是都会生成一个透明涂层专门绘制这个图形
* 绘制完成后，就覆盖在画布上。所以如果连续5次声明draw函数会城城5个透明涂层画完之后依次覆盖到画布上显示
* 有两种画布一种是onDraw函数中的canvas 一种是人造的例如通过bitmap 或者 saveLayer 方法 尤其是saveLayer 当调用这个方法后所有的
* canvas.draw 都是在这个画布上进行的 除非调用 restore（） restoreToCount()方法之后才会返回到原始画布上进行绘制
*
* Canvas 是画布的表现形式，我们所要绘制的任何东西都是通过Canvas实现的！声称方式只有一种就是new Canvas（bitmap）
* 无论是原始画布还是人造画布都是最终绘制到bitmap 上 Canvas相当于绘图的工具
*
*
* saveLayerAlpha(@Nullable RectF bounds, int alpha)
* 多了一个alpha参数，代表画布的透明度!透明度范围0-255 0是全透明
*
* */

class NineTwo @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var mWidth = 500
    private var mHeight = 500
    private var bitmap: Bitmap? = null
    private var srcmap: Bitmap? = null
    private var paint: Paint? = null


    init {
        setLayerType(LAYER_TYPE_SOFTWARE, null)
        srcmap = makeSrc(mWidth, mHeight)
        bitmap = makeBit(mWidth, mHeight)
        paint = Paint()

    }

    //创建一个正方形图片
    private fun makeBit(mWidth: Int, mHeight: Int): Bitmap? {
        val bitmap = Bitmap.createBitmap(mWidth, mHeight, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        val paint = Paint()
        paint.color = Color.YELLOW
        canvas.drawRect(0f, 0f, mWidth.toFloat(), mHeight.toFloat(), paint)
        return bitmap
    }

    //创建一个圆形图片
    private fun makeSrc(mWidth: Int, mHeight: Int): Bitmap? {
        val bitmap = Bitmap.createBitmap(mWidth, mHeight, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        val paint = Paint()
        paint.color = Color.RED
        canvas.drawOval(RectF(0f, 0f, mWidth.toFloat(), mHeight.toFloat()), paint)
        return bitmap
    }

    @SuppressLint("NewApi")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawColor(Color.BLUE)
        val id = canvas?.saveLayer(RectF(0f, 0f, mWidth * 2f, mHeight * 2f), Paint())
        canvas?.drawBitmap(srcmap!!, 0f, 0f, paint)
        //通过使用paint的xfermode进行图片的叠加效果
        paint?.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
        canvas?.drawBitmap(bitmap!!, mWidth / 2f, mHeight / 2f, paint)
        //注意将paint的fermode置空
        paint?.xfermode = null
        canvas?.skew(1.70f,1.2f)
        canvas?.restoreToCount(id!!)
    }
}