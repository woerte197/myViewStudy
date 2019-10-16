package com.example.myapplication.widget.ten.tenone

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.graphics.Region
import android.graphics.drawable.ShapeDrawable
import android.util.AttributeSet
import android.view.View

class RegionShapeView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var regionShapeView: ShapeDrawable? = null

    init {
        setLayerType(LAYER_TYPE_HARDWARE, null)
        val rect = Rect(50, 0, 90, 150)
        val rect2 = Rect(0, 50, 250, 100)
        val region = Region(rect)
        val region2 = Region(rect2)
        region.op(region2, Region.Op.XOR)

        regionShapeView = ShapeDrawable(RegionShape(region))
        regionShapeView?.bounds = Rect(0, 0, 250, 150)
        regionShapeView?.paint?.color = Color.RED
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        regionShapeView?.draw(canvas!!)
    }

}