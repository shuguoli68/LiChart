package com.li.lichart

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.li.lichart.activity.PieChartActivity

class MainActivity : AppCompatActivity() , View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.main_piechart -> startTo(PieChartActivity::class.java)
        }
    }

    fun <T> startTo(clazz: Class<T>){
        startActivity(Intent(this,clazz))
    }
}
