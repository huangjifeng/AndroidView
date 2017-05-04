package com.huangjifeng.gesturedetector;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.huangjifeng.gesturedetector.view.MyGestureListener;
import com.huangjifeng.gesturedetector.view.MyOnDoubleTapListener;

/*
* http://blog.csdn.net/harvic880925/article/details/39520901
*
* 这个示例里面的方法是用了GestureDetector.OnDoubleTapListener和GestureDetector.OnGestureListener
* 两个接口的实现，所以里面的方法都是需要实现的，而SimpleOnGestureListener已经实现了上面两个接口的全部
* 方法，所以只需要选择性的继承需要使用的方法即可
* */

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {


    private GestureDetector mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //所以要想使用OnDoubleTapListener的几个函数，就必须先实现OnGestureListener。
        mGestureDetector = new GestureDetector(this, new MyGestureListener(this));
        mGestureDetector.setOnDoubleTapListener(new MyOnDoubleTapListener());
        //mGestureDetector = new GestureDetector(this,new MySimpleOnGestureListener());

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


    /*
    * 它与前两个不同的是：
    * 1、这是一个类，在它基础上新建类的话，要用extends派生而不是用implements继承！
    * 2、OnGestureListener和OnDoubleTapListener接口里的函数都是强制必须重写的，即使用不到也要重写出
    * 来一个空函数但在SimpleOnGestureListener类的实例或派生类中不必如此，可以根据情况，用到哪个函数
    * 就重写哪个函数，因为SimpleOnGestureListener类本身已经实现了这两个接口的所有函数，只是里面全是空的而已。
    * */
    class MySimpleOnGestureListener extends GestureDetector.SimpleOnGestureListener {
        public MySimpleOnGestureListener() {
            super();
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            return super.onSingleTapUp(e);
        }

        @Override
        public void onLongPress(MotionEvent e) {
            super.onLongPress(e);
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            return super.onScroll(e1, e2, distanceX, distanceY);
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            return super.onFling(e1, e2, velocityX, velocityY);
        }

        @Override
        public void onShowPress(MotionEvent e) {
            super.onShowPress(e);
        }

        @Override
        public boolean onDown(MotionEvent e) {
            return super.onDown(e);
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            return super.onDoubleTap(e);
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            return super.onDoubleTapEvent(e);
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            return super.onSingleTapConfirmed(e);
        }

        @Override
        public boolean onContextClick(MotionEvent e) {
            return super.onContextClick(e);
        }
    }
}
