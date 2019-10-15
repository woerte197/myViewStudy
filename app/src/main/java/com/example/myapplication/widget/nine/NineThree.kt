package com.example.myapplication.widget.nine

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import android.util.AttributeSet
import android.view.View
import androidx.annotation.RequiresApi

/*
* Flag的具体含义
* canvas 有几个具体的save函数
* save() 默认flag MATRIX_SAVE_FLAG | CLIP_SAVE_FLAG
* save(@Saveflags int saveFlags)已经废弃推荐使用save
* saveLayer(@Nullable RectF bounds, @Nullable Paint paint, @Saveflags int saveFlags)
* saveLayer(@Nullable RectF bounds, @Nullable Paint paint)
* saveLayerAlpha(@Nullable RectF bounds, int alpha, @Saveflags int saveFlags)
* saveLayerAlpha(@Nullable RectF bounds, int alpha)
* 其中flag 参数含义如下
* Canvas.ALL_SAVE_FLAG 保存有所标识        适用范围  saveLayer save
* MATRIX_SAVE_FLAG     仅保存Matrix数组    适用范围  saveLayer save
* CLIP_SAVE_FLAG       仅保存Canvas当前大小当恢复画布是只恢复大小！对于未知信息是不会被恢复的旋转平移等
* // 下面3个主要是saveLayer方法对新建画布特性的FLAG
* HAS_ALPHA_LAYER_SAVE_FLAG  标识新建的bitmap具有透明度，在与上层画布结合是。
* 透明位置显示上层的图像，与 FULL_COLOR_LAYER_SAVE_FLAG冲突，若为同时指定以
* HAS_ALPHA_LAYER_SAVE_FLAG 为准           适用范围 saveLayer
* FULL_COLOR_LAYER_SAVE_FLAG 标识新建的bitmap颜色完全独立，在与上层画布结合时，先清空上层画布
* 在覆盖上去                               适用范围 saveLayer
* CLIP_TO_LAYER_SAVE_FLAG 在保存图层前先把当前画布根据bounds裁剪，与CLIP_SAVE_FLAG冲突
* 若同时指定以与CLIP_SAVE_FLAG为准          适用范围 saveLayer
* 在恢复是只会吧当前saveLayer创建的画布内容进行叠加而不会把裁剪的canvas恢复
* 当于CLIP_SAVE_FLAG 一同使用时会将canvas恢复
*
* save 默认的flag ALL_SAVE_FLAG = MATRIX_SAVE_FLAG|CLIP_SAVE_FLAG
* 对于 saveLayer来说 ALL_SAVE_FLAG = MATRIX_SAVE_FLAG|CLIP_SAVE_FLAG|HAS_ALPHA_LAYER_SAVE_FLAG
* restore函数 与restoreToCount函数是同一个栈可以通用每次save 函数 都会增加一次
* restore 直接回退到栈顶  而restoreToCount回退到对应id之前
* */
class NineThree @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var mPaint: Paint? = null

    init {
        mPaint = Paint()
        mPaint?.color = Color.GRAY
    }

    /*
    * CLIP_SAVE_FLAG 与  MATRIX_SAVE_FLAG
    * */
//    override fun onDraw(canvas: Canvas?) {
//        super.onDraw(canvas)
//        canvas?.save()
//        canvas?.rotate(40f)
//        canvas?.drawRect(0f, 0f, 100f, 100f, mPaint!!)
//        canvas?.clipRect(100f, 0f, 200f, 100f)
//        canvas?.drawColor(Color.GRAY)
//        canvas?.restore()
//        mPaint?.color = Color.RED
//        canvas?.drawRect(0f, 0f, 100f, 100f, mPaint!!)
//        canvas?.drawColor(Color.BLACK)
//    }

//    @SuppressLint("NewApi", "WrongConstant")
//    override fun onDraw(canvas: Canvas?) {
//        super.onDraw(canvas)
//        canvas?.drawColor(Color.RED)
//        canvas?.saveLayer(0f, 0f, 200f, 200f, mPaint,0x10)
//        canvas?.drawColor(Color.GRAY)
//        mPaint?.color = Color.GREEN
//        canvas?.drawRect(0f, 0f, 100f, 100f, mPaint!!)
//        canvas?.clipRect(0f,0f,200f,200f)
//        canvas?.restore()
//        canvas?.drawColor(Color.BLACK)
//    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        var a = canvas?.saveLayer(0f, 0f, 500f, 500f, mPaint!!)
        canvas?.drawColor(Color.RED)
        var b = canvas?.saveLayer(0f, 0f, 400f, 400f, mPaint!!)
        canvas?.drawColor(Color.GRAY)
        var c = canvas?.saveLayer(0f, 0f, 300f, 300f, mPaint!!)
        canvas?.drawColor(Color.GREEN)
        var d = canvas?.saveLayer(0f, 0f, 200f, 200f, mPaint!!)
        canvas?.drawColor(Color.WHITE)
        var e = canvas?.saveLayer(0f, 0f, 100f, 100f, mPaint!!)
        canvas?.drawColor(Color.BLACK)
        canvas?.restoreToCount(d!!)
        canvas?.drawColor(Color.WHITE)

    }

}