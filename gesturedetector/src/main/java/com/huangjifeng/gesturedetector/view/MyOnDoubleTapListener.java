package com.huangjifeng.gesturedetector.view;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * Created by Administrator on 2017/5/4.
 */

public class MyOnDoubleTapListener implements GestureDetector.OnDoubleTapListener {
    private static final String TAG = "MyOnDoubleTapListener";

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        Log.v(TAG, "onSingleTapConfirmed  --  " + e.getAction());
        /*
        * 单击事件。用来判定该次点击是SingleTap而不是DoubleTap，如果连续点击两次就是DoubleTap手势，
        * 如果只点击一次，系统等待一段时间后没有收到第二次点击则判定该次点击为SingleTap而不是DoubleTap，
        * 然后触发SingleTapConfirmed事件。触发顺序是：OnDown->OnsingleTapUp->OnsingleTapConfirmed,
        * 关于onSingleTapConfirmed和onSingleTapUp的一点区别： OnGestureListener有这样的一个方法onSingleTapUp，
        * 和onSingleTapConfirmed容易混淆。二者的区别是：onSingleTapUp，只要手抬起就会执行，
        * 而对于onSingleTapConfirmed来说，如果双击的话，则onSingleTapConfirmed不会执行。
        *
        * */
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        Log.v(TAG, "-------------onDoubleTap  --  " + e.getAction());
        //双击事件
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        Log.v(TAG, "-----++++++++++++--------onDoubleTapEvent----------  --  " + e.getAction());
        //双击间隔中发生的动作。指触发onDoubleTap以后，在双击之间发生的其它动作，包含down、up和move事件；

        /*
        * 在第二下点击时，先触发OnDoubleTap，然后再触发OnDown（第二次点击）
        *
        * 其次在触发OnDoubleTap以后，就开始触发onDoubleTapEvent了，onDoubleTapEvent后面的数字代表了
        * 当前的事件，0指ACTION_DOWN，1指ACTION_UP，2 指ACTION_MOVE
        * */
        return true;
    }
}
