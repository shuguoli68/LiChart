# LiChart
kotlin编写的自定义图表控件

To get a Git project into your build:

Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.shuguoli68:LiChart:1.01'
	}

###Join the layout
```xml
<com.li.piechart.PieChart
        android:id="@+id/pie_chart"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
    />  
```
###Set the data.PieChart
```java
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
```
![mahua](mahua-logo.jpg)

###Set the data.RingChart
```java
        pie_chart.pushData(list)
            .pieBg(pxDpUtil.dip2px(50).toFloat(),pxDpUtil.dip2px(310).toFloat())
            .pieTitle("一季度订单分布图",pxDpUtil.sp2px(15).toFloat(), Color.RED)
            .ringSize(pxDpUtil.dip2px(100).toFloat(),Color.WHITE)
```
![mahua](mahua-logo.jpg)
	
