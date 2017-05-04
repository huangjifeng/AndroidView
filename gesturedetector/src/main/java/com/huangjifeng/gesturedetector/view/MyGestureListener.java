package com.huangjifeng.gesturedetector.view;

import android.content.Context;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/5/3.
 */

public class MyGestureListener implements GestureDetector.OnGestureListener {
    private static final String TAG = "MyGestureListener";
    private final Context mContext;

    public MyGestureListener(Context context) {
        this.mContext = context;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        // 用户轻触触摸屏，由1个MotionEvent ACTION_DOWN触发  
        Log.v(TAG, "onDown");
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        Log.v(TAG, "onShowPress----");
         /*
         * 用户轻触触摸屏，尚未松开或拖动，由一个1个MotionEvent ACTION_DOWN触发
         * 注意和onDown()的区别，强调的是没有松开或者拖动的状态
         *
         * 而onDown也是由一个MotionEventACTION_DOWN触发的，但是他没有任何限制，
         * 也就是说当用户点击的时候，首先MotionEventACTION_DOWN，onDown就会执行，
         * 如果在按下的瞬间没有松开或者是拖动的时候onShowPress就会执行，如果是按下的时间超过瞬间
         * （这块我也不太清楚瞬间的时间差是多少，一般情况下都会执行onShowPress），拖动了，就不执行onShowPress。
         */
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        Log.v(TAG, "---------onSingleTapUp----");

        //从名字也可以看出,一次单独的轻击抬起操作,也就是轻击一下屏幕，立刻抬起来，才会有这个触发，
        // 当然,如果除了Down以外还有其它操作,那就不再算是Single操作了,所以也就不会触发这个事件
        //触发顺序：
        //点击一下非常快的（不滑动）Touchup：onDown->onSingleTapUp->onSingleTapConfirmed
        //点击一下稍微慢点的（不滑动）Touchup：onDown->onShowPress->onSingleTapUp->onSingleTapConfirmed

        // 用户（轻触触摸屏后）松开，由一个1个MotionEvent ACTION_UP触发
        ///轻击一下屏幕，立刻抬起来，才会有这个触发
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Log.v(TAG, "---------+++++++++++++-------------onScroll----");

        /*
        * 在屏幕上拖动事件。无论是用手拖动view，或者是以抛的动作滚动，都会多次触发,这个方法
        * 在ACTION_MOVE动作发生时就会触发
            滑屏：手指触动屏幕后，稍微滑动后立即松开
            onDown-----》onScroll----》onScroll----》onScroll----》………----->onFling
            拖动
            onDown------》onScroll----》onScroll------》onFiling
            可见，无论是滑屏，还是拖动，影响的只是中间OnScroll触发的数量多少而已，最终都会触发onFling事件！
        *
        * */

        // 用户按下触摸屏，并拖动，由1个MotionEvent ACTION_DOWN, 多个ACTION_MOVE触发
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        Log.v(TAG, "+++++++++-------onLongPress----");

        //长按触摸屏，超过一定时长，就会触发这个事件
        //触发顺序：onDown->onShowPress->onLongPress
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        if (e1.getX() - e2.getX() > 100 && Math.abs(velocityX) > 100) {
            Toast.makeText(mContext, "向左滑动了", Toast.LENGTH_SHORT).show();
        } else if (e2.getX() - e1.getX() > 100 && Math.abs(velocityX) > 100) {
            Toast.makeText(mContext, "向右----------滑动了", Toast.LENGTH_SHORT).show();
        }

        Log.v(TAG, "******************--------------------+++++++++-------onFling----");
        /*
        * 滑屏，用户按下触摸屏、快速移动后松开，由1个MotionEvent ACTION_DOWN, 多个ACTION_MOVE, 1个ACTION_UP触发
             参数解释：
            e1：第1个ACTION_DOWN          MotionEvent
            e2：最后一个ACTION_MOVE       MotionEvent
            velocityX：X轴上的移动速度，像素/秒
            velocityY：Y轴上的移动速度，像素/秒
        * */
        return true;
    }
}
