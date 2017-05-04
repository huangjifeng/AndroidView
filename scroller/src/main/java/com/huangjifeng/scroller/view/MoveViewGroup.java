package com.huangjifeng.scroller.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * Created by Administrator on 2017/5/4.
 */

   /*
    * View  类中   scroll 方法
    *
    * View中scrollBy()方法是让View相对于当前的位置滚动某段距离，而scrollTo()方法则是让View相对于初始的位置滚动某段距离。
    * 不管是scrollTo()还是scrollBy()方法，滚动的都是该View内部的内容，而LinearLayout中的内容就是我们的两个Button，
    * 如果你直接调用button的scroll方法的话，那结果一定不是你想看到的。
    *
    * 就是两个scroll方法中传入的参数，第一个参数x表示相对于当前位置横向移动的距离，正值向左移动，
    * 负值向右移动，单位是像素。第二个参数y表示相对于当前位置纵向移动的距离，正值向上移动，负值向下移动，单位是像素。
    *
    * scrollTo()方法是让View相对于初始的位置滚动某段距离，由于View的初始位置是不变的，因此不管我们
    * 点击多少次scrollTo按钮滚动到的都将是同一个位置。而scrollBy()方法则是让View相对于当前的位置滚动
    * 某段距离，那每当我们点击一次scrollBy按钮，View的当前位置都进行了变动，因此不停点击会一直向右下方移动。
    * */

public class MoveViewGroup extends RelativeLayout {
    private int lastX;
    private int lastY;

    public MoveViewGroup(Context context) {
        super(context);
    }

    public MoveViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        int localX = (int) event.getX();
        int localY = (int) event.getY();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                lastX = localX;
                lastY = localY;
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = localX - lastX;
                int offsetY = localY - lastY;
                //layout(getLeft() + offsetX, getTop() + offsetY, getRight() + offsetX, getBottom() + offsetY);
                scrollBy(-offsetX/10, -offsetY/10);
                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_CANCEL:
                break;
        }

        return true;
    }
}
