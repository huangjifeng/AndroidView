package com.huangjifeng.location;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/*
* https://github.com/GcsSloop/AndroidNote/tree/master/CustomView
*
* */

public class MainActivity extends AppCompatActivity {

    /*
    * 这里为坐标的相关介绍
    *
    * 移动设备一般定义屏幕左上角为坐标原点，向右为x轴增大方向，向下为y轴增大方向
    *
    *
    *   getTop();       //获取子View左上角距父View顶部的距离
        getLeft();      //获取子View左上角距父View左侧的距离
        getBottom();    //获取子View右下角距父View顶部的距离
        getRight();     //获取子View右下角距父View左侧的距离
    *
    *
    * event.getX();   event.getY();  //触摸点相对于其所在组件坐标系的坐标
    * event.getRawX();  event.getRawY();   //触摸点相对于屏幕默认坐标系的坐标
    * */

    /*
    * 这里为角度的相关介绍：角度和弧度
    *
    * 360(角度) = 2π(弧度) ==> 180(角度) = π(弧度)
    * 在默认的屏幕坐标系中角度增大方向为顺时针。
    *
    * */

    /*
    * 这里为颜色的相关介绍
    *
    *
    * */



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
