package ru.smak.vmk_painting.ui.painting

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class BoxPainter(context: Context, attrs: AttributeSet?) : View(context, attrs){
    constructor(context: Context) : this(context, null)

    private val bg: Paint = Paint()
    private val box = Paint()
    private var point1: PointF? = null
    private var point2: PointF? = null
    init{
        bg.color = 0xfffffff0.toInt()
        box.color = 0x8000ff00.toInt()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.apply{
            drawPaint(bg)
            /*drawRect(100F, 100F, 500F, 500F, box)
            drawRect(300F, 300F, 700F, 700F, box)*/
            point1?.let{ p1->
                point2?.let{ p2->
                    drawRect(p1.x, p1.y, p2.x, p2.y, box)
                }
            }
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action){
            MotionEvent.ACTION_DOWN -> {
                point1 = PointF(event.x, event.y)
            }
            MotionEvent.ACTION_UP -> {
                point2 = PointF(event.x, event.y)
                invalidate()
            }
        }
        return true
    }
}