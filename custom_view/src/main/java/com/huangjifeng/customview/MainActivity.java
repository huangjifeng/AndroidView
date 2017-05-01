package com.huangjifeng.customview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);

        /*
        * 在刚启动程序时，使用getLeft(), getRight(), getTop(), getBottom()它们得到的结果是0，
        * 程序刚开始绘制 view 的时候，你马上使用代码去捕获上面的值。这个时候，
        * 由于view 是刚开始绘制的，你得到的就会是 0.
        *
        * */
        getButtonLocation(button);


    }

    private void getButtonLocation(final View view) {
        final View mView = view;
        view.postDelayed(new Runnable() {
            @Override
            public void run() {
                /*
                * 在Android中，x轴和y轴的正方向分别是向右和向下
                * 以下获取的坐标都是相对于父容器的坐标，即视图坐标系
                * */
                int left = mView.getLeft();
                int right = mView.getRight();
                int top = mView.getTop();
                int bottom = mView.getBottom();
                int width = right - left;
                int height = bottom - top;
                float x = mView.getX();        //view相对于父容器的左上角横坐标
                float y = mView.getY();        //view相对于父容器的左上角纵坐标
                Log.v("haha", "left = " + left + " x = " + x);
                Log.v("haha", "width = " + width + " height = " + height);
                int[] mm = new int[2];

                //计算该视图在全局坐标系中的x，y值，获取在当前屏幕内的绝对坐标
                mView.getLocationOnScreen(mm);
                for (int i = 0; i < mm.length; i++) {
                    Log.v("haha", "mm[i] = " + mm[i]);
                }
            }
        }, 200);
    }
}
