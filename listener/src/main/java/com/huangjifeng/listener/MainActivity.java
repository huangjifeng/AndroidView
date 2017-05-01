package com.huangjifeng.listener;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/*
* http://www.jianshu.com/p/e99b5e8bd67b
*
* */
public class MainActivity extends AppCompatActivity {

    private RelativeLayout mRelative;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        mRelative = (RelativeLayout) findViewById(R.id.activity_main);
        mRelative.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        /*
        * onTouch和onTouchEvent都是在View的dispatchTouchEvent中调用的，onTouch优先于onTouchEvent执行。
        * 如果在onTouch方法中通过返回true将事件消费掉，onTouchEvent将不会再执行。
        * onTouch能够得到执行需要两个前提条件，第一mOnTouchListener的值不能为空，第二当前点击的控件
        * 必须是enable的。因此如果你有一个控件是非enable的，那么给它注册onTouch事件将永远得不到执行。
        * 对于这一类控件，如果我们想要监听它的touch事件，就必须通过在该控件中重写onTouchEvent方法来实现。
        * android:clickable="true"        ---> 对应的是可点击     onClick(View v)
          android:enabled="true"          ---> 对应的是可触摸     onTouch(View v, MotionEvent event)
        *
        * 源码分析：执行dispatchTouchEvent时，一定会执行onTouch事件，如果onTouch返回true，则不会执行onTouchEvent(event)
        * 也就是不会执行onClick()事件
        * if (li != null && li.mOnTouchListener != null
                    && (mViewFlags & ENABLED_MASK) == ENABLED
                    && li.mOnTouchListener.onTouch(this, event)) {
                result = true;
            }

            if (!result && onTouchEvent(event)) {
                result = true;
            }
        *
        * View的事件分发，事件指的是  down ---》 move --》 up   事件
	        1.dispatchTouchEvent（）；
	        2.onTouchListener-->onTouch方法
	        3.onTouchEvent()
	        4.onClickListener-->onClick方法
        *
        * 1.如果onTouchListener的onTouch方法返回了true，那么view里面的onTouchEvent就不会被调用了。
        *       顺序dispatchTouchEvent-->onTouchListener---return false-->onTouchEvent
        * 2.如果view为disenable,则：onTouchListener里面不会执行，但是会执行onTouchEvent(event)方法
        * 3.onTouchEvent方法中的ACTION_UP分支中触发onclick事件监听
        * onTouchListener-->onTouch方法返回true，消耗此事件。在down时就消耗了,但是up事件是无法到达onClickListener.
        * onTouchListener-->onTouch方法返回false，不会消耗此事件
        * */
        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                return false;
            }
        });
        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return false;
            }
        });
        button.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                return false;
            }
        });
        button.setOnContextClickListener(new View.OnContextClickListener() {
            @Override
            public boolean onContextClick(View v) {
                return false;
            }
        });
        button.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                return false;
            }
        });
        button.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

            }
        });
    }
}
