package com.huangjifeng.androidview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.TextView;

import com.huangjifeng.androidview.View.MyView;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private MyView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myView = (MyView) findViewById(R.id.my_view);

        // 向 ViewTreeObserver 注册方法，以获取控件尺寸，该方法在 onGlobalLayout() 方法将在控件完成绘制后调用，
        // 因而可以得到正确地结果。该方法在 Fragment 中，也可以使用。
        ViewTreeObserver vto = myView.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int left = myView.getLeft();
                int right = myView.getRight();
                int top = myView.getTop();
                int bottom = myView.getBottom();
                // 成功调用一次后，移除 Hook 方法，防止被反复调用
                myView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });

        //该方法同样在 Fragment 中适用，是目前笔者发现的最佳解决方案。
        myView.post(new Runnable() {
            @Override
            public void run() {
                int left = myView.getLeft();
                int right = myView.getRight();
                int top = myView.getTop();
                int bottom = myView.getBottom();
            }
        });


        button = new Button(this);
        /*setClickable 设置为true时，表明控件可以点击，如果为false，就不能点击；“点击”适用于鼠标、键盘按键、遥控器等；
        注意，setOnClickListener方法会默认把控件的setClickable设置为true。*/
        button.setClickable(true);
        /*setEnabled  如果设置为false，该控件永远不会活动，不管设置为什么属性，都无效；设置为true，
        表明激活该控件，控件处于活动状态，处于活动状态，就能响应事件了，比如触摸、点击、按键事件等；
        setEnabled就相当于总开关一样，只有总开关打开了，才能使用其他事件。*/
        button.setEnabled(true);
        /*setFocusable 使控件获得焦点，设置为true时，并不是说立刻获得焦点，要想立刻获得焦点，
        得用requestFocus；使能获得焦点，就是说具备获得焦点的机会、能力，当有焦点在控件之间移动时，
        控件就有这个机会、能力得到焦点。*/
        button.setFocusable(true);

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        //该生命周期方法中获取的控件尺寸是正确的
        int left = myView.getLeft();
        int right = myView.getRight();
        int top = myView.getTop();
        int bottom = myView.getBottom();
    }
}
