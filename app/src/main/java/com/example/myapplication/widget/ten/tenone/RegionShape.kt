package com.example.myapplication.widget.ten.tenone

import android.graphics.*
import android.graphics.drawable.shapes.Shape

class RegionShape(var region: Region) : Shape() {
    override fun draw(canvas: Canvas?, paint: Paint?) {
        var regionIterator = RegionIterator(region)
        val rect = Rect()
        while (regionIterator.next(rect)) {
            canvas?.drawRect(rect,paint!!)
        }
    }
}


