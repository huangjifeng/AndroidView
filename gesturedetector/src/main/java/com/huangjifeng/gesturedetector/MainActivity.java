package com.huangjifeng.gesturedetector;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.huangjifeng.gesturedetector.view.MyGestureListener;

/*
* http://blog.csdn.net/harvic880925/article/details/39520901
*
* */

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {


    private GestureDetector mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGestureDetector = new GestureDetector(this, new MyGestureListener(this));
        TextView mTextViewGes = (TextView) findViewById(R.id.text_view_gesture);
        mTextViewGes.setOnTouchListener(this);
        mTextViewGes.setClickable(true);
        mTextViewGes.setFocusable(true);
        mTextViewGes.setLongClickable(true);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
         /*
         * 在onTouch()方法中，我们调用GestureDetector的onTouchEvent()方法，将捕捉到的MotionEvent
         * 交给GestureDetector来分析是否有合适的callback函数来处理用户的手势
         */
        return mGestureDetector.onTouchEvent(event);
    }
}
