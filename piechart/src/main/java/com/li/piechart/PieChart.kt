package com.li.piechart

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.text.TextUtils
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import java.text.DecimalFormat

class PieChart: View {
    private var bg:Int = Color.parseColor("#8f008577")
    private lateinit var mPaint: Paint
    private lateinit var titlePaint: Paint
    private var bgLeft = 100.0f
    private var bgRight = 620.0f
    private lateinit var list:MutableList<PieChartBean>
    private var allCount = 0.0f//总的数量
    private var scale = "3.12%"//占总数的比例r
    private var title = "PieChart"
    private val decimalFormat = DecimalFormat(".00")
    private var ringRadio = 0.0f//完全透明圆的半径，叠加成环
    private var ringColor = bg//完全透明圆的颜色，叠加成环

    constructor(context: Context) : super(context) {init()}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {init()}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {init()}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    ) {
        init()
    }

    private fun init() {
        mPaint = Paint()
        mPaint.textSize = 20.0f
        mPaint.isAntiAlias = true
        mPaint.style = Paint.Style.FILL_AND_STROKE
        mPaint.color = Color.GRAY

        titlePaint = Paint()
        titlePaint.textSize = 20.0f
        titlePaint.isAntiAlias = true
        titlePaint.style = Paint.Style.FILL_AND_STROKE
        titlePaint.color = Color.GRAY

        list = mutableListOf()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)
        // 设置wrap_content的默认宽 / 高值,默认宽/高的设定并无固定依据,根据需要灵活设置
        val mWidth:Int = (bgLeft+bgRight).toInt()
        val mHeight:Int = (bgLeft+bgRight).toInt()
        // 当布局参数设置为wrap_content时，设置默认值
        if (layoutParams.width == ViewGroup.LayoutParams.WRAP_CONTENT && layoutParams.height == ViewGroup.LayoutParams.WRAP_CONTENT){
            setMeasuredDimension(mWidth,mHeight)
        }else if (layoutParams.width == ViewGroup.LayoutParams.WRAP_CONTENT){
            setMeasuredDimension(mWidth,heightSize)
        }else if (layoutParams.height == ViewGroup.LayoutParams.WRAP_CONTENT){
            setMeasuredDimension(widthSize,mHeight)
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val rect1: RectF = RectF(bgLeft, bgLeft, bgRight, bgRight)
        val txtHeight = -titlePaint.fontMetrics.ascent - titlePaint.fontMetrics.descent
        canvas?.drawColor(bg)
        if (!TextUtils.isEmpty(title)) {
            canvas?.drawText(title,(bgRight-bgLeft)/2+bgLeft-titlePaint.measureText(title)/2,bgRight+txtHeight*2,titlePaint)
        }
        for (pieChart in list){
            mPaint.color = pieChart.color
            val sweep = pieChart.stopAngle-pieChart.startAngle
            scale = decimalFormat.format(sweep/allCount*100)+"%"
            canvas?.drawArc(rect1,pieChart.startAngle,sweep,true,mPaint)
            drawMsg(pieChart.startAngle,sweep,pieChart.msg,canvas)
        }
        mPaint.color = ringColor
        canvas?.drawCircle((bgRight-bgLeft)/2+bgLeft,(bgRight-bgLeft)/2+bgLeft,ringRadio,mPaint)
    }

    private fun drawMsg(start:Float,sweep:Float,msg:String,canvas: Canvas?){
        val txtWidth = mPaint.measureText(msg)
        val txtHeight = -mPaint.fontMetrics.ascent - mPaint.fontMetrics.descent
        val radio = (bgRight-bgLeft)/2
        val angle = ((-start)-sweep/2.0)*Math.PI/180.0
        val x1 = radio*Math.cos(angle)
        val y1 = radio*Math.sin(angle)
        var isLeft = true//左边,false右边
        var x = x1+bgLeft+radio
        if (x1>=0){
            isLeft = false
        }
        var y = -y1+bgLeft+radio
        var stopX = bgRight+30.0f
        var txtStart:Float = stopX+5
        if (isLeft){
            stopX = bgLeft-30.0f
            txtStart =stopX - txtWidth -5
        }
        canvas?.drawLine(x.toFloat(),y.toFloat(),stopX,y.toFloat(),mPaint)
        canvas?.drawText(msg,txtStart,y.toFloat(),mPaint)
        canvas?.drawText(scale,txtStart,y.toFloat()+txtHeight*3/2,mPaint)
    }


    fun pushData(list:MutableList<PieChartBean>):PieChart{
        if (list!=null && list.size>0){
            this.list.clear()
            this.list.addAll(list)
        }
        for (pie in this.list){
            allCount += pie.stopAngle - pie.startAngle
        }
        return this
    }

    fun pieBg(pLeft:Float,pRight:Float):PieChart{
        bgLeft = pLeft
        bgRight = pRight
        return this
    }
    fun pieTitle(title:String,txtSize:Float,txtColor:Int):PieChart{
        this.title = title
        titlePaint.textSize = txtSize
        titlePaint.color = txtColor
        return this
    }
    fun pieTitle(title:String):PieChart{
        this.title = title
        return this
    }
    fun backG(color: Int):PieChart{
        bg = color
        return this
    }
    fun ringSize(size:Float,color:Int):PieChart{
        ringRadio = size
        ringColor = color
        return this
    }
}