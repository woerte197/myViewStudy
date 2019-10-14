package com.example.myapplication.widget.nine

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
/*
* Flag的具体含义
* canvas 有几个具体的save函数
* save()
* save(@Saveflags int saveFlags)
* saveLayer(@Nullable RectF bounds, @Nullable Paint paint, @Saveflags int saveFlags)
* saveLayer(@Nullable RectF bounds, @Nullable Paint paint)
* saveLayerAlpha(@Nullable RectF bounds, int alpha, @Saveflags int saveFlags)
* saveLayerAlpha(@Nullable RectF bounds, int alpha)
* 其中flag 参数含义如下
* Canvas.ALL_SAVE_FLAG 保存有所标识        适用范围  saveLayer save
* MATRIX_SAVE_FLAG     仅保存Matrix数组    适用范围  saveLayer save
* CLIP_SAVE_FLAG       仅保存Canvas当前大小
* HAS_ALPHA_LAYER_SAVE_FLAG
* */
class NineThree @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr){


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }
}