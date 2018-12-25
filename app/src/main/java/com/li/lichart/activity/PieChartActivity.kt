package com.li.lichart.activity

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.li.lichart.R
import com.li.piechart.PieChartBean
import com.li.piechart.PxDpUtil
import kotlinx.android.synthetic.main.activity_piechart.*

class PieChartActivity : AppCompatActivity (){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_piechart)
        initView()
    }

    private fun initView() {
        //图表数据：数学中的x轴正半轴顺时针为正，逆时针为负。
        val list = mutableListOf<PieChartBean>(
            PieChartBean("一月份",-30.0f,30.0f, Color.BLUE)
            ,PieChartBean("二月份",35.0f,65.0f, Color.GREEN)
            ,PieChartBean("三月份",70.0f,170.0f, Color.BLACK)
            ,PieChartBean("四月份",175.0f,325.0f, Color.RED)
        )
        val pxDpUtil = PxDpUtil(this)
        pie_chart.pushData(list)
            .pieBg(pxDpUtil.dip2px(50).toFloat(),pxDpUtil.dip2px(310).toFloat())
            .pieTitle("一季度订单分布图",pxDpUtil.sp2px(15).toFloat(), Color.RED)
            .ringSize(pxDpUtil.dip2px(100).toFloat(),Color.WHITE)
            .backG(Color.parseColor("#00000000"))
    }
}