package com.li.piechart

import android.content.Context

class PxDpUtil(private var mContext: Context){

    /**
     * dp转px
     * @param dp
     * @return
     */
    fun dip2px(dp: Int): Int {
        val density = mContext.resources.displayMetrics.density
        return (dp * density + 0.5).toInt()
    }

    /** px转换dip  */
    fun px2dip(px: Int): Int {
        val scale = mContext.resources.displayMetrics.density
        return (px / scale + 0.5f).toInt()
    }

    /** px转换sp  */
    fun px2sp(pxValue: Int): Int {
        val fontScale = mContext.resources.displayMetrics.scaledDensity
        return (pxValue / fontScale + 0.5f).toInt()
    }

    /** sp转换px  */
    fun sp2px(spValue: Int): Int {
        val fontScale = mContext.resources.displayMetrics.scaledDensity
        return (spValue * fontScale + 0.5f).toInt()
    }
}