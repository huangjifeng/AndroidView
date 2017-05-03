package com.huangjifeng.velocitytracker.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;

/**
 * Created by Administrator on 2017/5/3.
 */

public class MyView extends View {
    private static final String TAG = "MyView_velocity";
    private final Context mContext;
    private VelocityTracker mVelocityTracker;
    private int mPointID;
    private static final String sFormatStr = "velocityX=%f\nvelocityY=%f";
    /*
    * VelocityTracker通过跟踪一连串事件实时计算出当前的速度
    *
    * */


    public MyView(Context context) {
        this(context, null);
    }

    public MyView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        //获取一个VelocityTracker对象, 用完后记得回收
        mVelocityTracker = VelocityTracker.obtain();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        acquireVelocityTracker(event);
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                //求第一个触点的id， 此时可能有多个触点，但至少一个
                mPointID = event.getPointerId(0);
                break;
            case MotionEvent.ACTION_MOVE:
                //计算当前速度, 其中units是单位表示， 1代表px/毫秒, 1000代表px/秒, ..
                mVelocityTracker.computeCurrentVelocity(1000);
                //经过一次computeCurrentVelocity后你就可以用一下几个方法获取此次计算的值
                //id是touch event触摸点的ID, 来为多点触控标识，有这个标识在计算时可以忽略
                //其他触点干扰，当然干扰肯定是有的
                float velocityX = mVelocityTracker.getXVelocity(mPointID);
                float velocityY = mVelocityTracker.getYVelocity(mPointID);
                recodeInfo(velocityX, velocityY);
                break;
            case MotionEvent.ACTION_UP:
                releaseVelocityTracker();
                break;
            case MotionEvent.ACTION_CANCEL:
                releaseVelocityTracker();
                break;
            default:
                break;
        }
        return true;
    }

    //回收后代表你不需要使用了，系统将此对象在此分配到其他请求者
    private void releaseVelocityTracker() {
        if (mVelocityTracker != null) {
            mVelocityTracker.clear();
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        }
    }

    //记录当前速度
    private void recodeInfo(float velocityX, float velocityY) {
        String info = String.format(sFormatStr, velocityX, velocityY);
        Log.v(TAG, info);
    }

    //向VelocityTracker添加MotionEvent
    private void acquireVelocityTracker(MotionEvent event) {
        if (mVelocityTracker == null) {
            mVelocityTracker = VelocityTracker.obtain();
        }
        mVelocityTracker.addMovement(event);
    }
}
