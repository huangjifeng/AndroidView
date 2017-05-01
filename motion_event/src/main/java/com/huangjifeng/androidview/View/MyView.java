package com.huangjifeng.androidview.View;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2017/5/1.
 */

public class MyView extends View {
    /*
    * View的相关事件只有两个：dispatchTouchEvent、onTouchEvent。
    * public static final int ACTION_DOWN = 0;  单点触摸按下动作
    * public static final int ACTION_UP = 1;    单点触摸离开动作
    * public static final int ACTION_MOVE = 2;  触摸点移动动作
    * public static final int ACTION_CANCEL = 3;  触摸动作取消
    * public static final int ACTION_OUTSIDE = 4;   触摸动作超出边界
    * public static final int ACTION_POINTER_DOWN = 5;   多点触摸按下动作
    * public static final int ACTION_POINTER_UP = 6;     多点离开动作
    *
    * */

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        //触摸点相对于屏幕的坐标系----Android 坐标系
        float layoutX = event.getRawX();
        float layoutY = event.getRawY();
        //触摸点相对于点击控件的坐标系----视图坐标系
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        Log.v("haha", "layoutX == " + layoutX + "layoutY === " + layoutY);
        Log.v("haha", "x == " + x + "y === " + y);

        return true;
    }


}
