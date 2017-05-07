package com.huangjifeng.paint.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * 这个自定义view主要讲解text绘制时的一些坑
 * <p>
 * 基线：是字母a、b、c等下面的这条虚拟的线，是不存在的。不过其他线都是以这条线作为参考
 * top 线：整个text最上面的这条线，在基线之上，所以是负值
 * ascent 线：在top之下基线之上的线，主要是f 字母上面的这条线，也是负值
 * descent 线：在基线之下，bottom之上的这根线，字母g 下面的这条线，正值
 * bottom 线：整个text最下面的这条线，正值
 */

public class BaseLineView extends View {

    private Paint mPaint;
    private String str = "agdbpty";
    int top = 300;

    public BaseLineView(Context context) {
        this(context, null);
    }

    public BaseLineView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setTextSize(200);
        mPaint.setColor(Color.RED);
        mPaint.setAntiAlias(true);
        mPaint.setTextAlign(Paint.Align.LEFT);
        //canvas.drawText(str, 0, top, mPaint);
        mPaint.setColor(Color.BLACK);

        //所有的4个值都是以基线baseLine为基准来计算的，baseLine以上就是负值，以下都是正值
        Paint.FontMetrics fontMetrics = mPaint.getFontMetrics();
        canvas.drawLine(0, top, 2000, top, mPaint);
        //canvas.drawLine(0, top + fontMetrics.top, 2000, top + fontMetrics.top, mPaint);
        //canvas.drawLine(0, top + fontMetrics.bottom, 2000, top + fontMetrics.bottom, mPaint);
        //canvas.drawLine(0, top + fontMetrics.ascent, 2000, top + fontMetrics.ascent, mPaint);
        //canvas.drawLine(0, top + fontMetrics.descent, 2000, top + fontMetrics.descent, mPaint);

        //在做自定义控件的时候canvas.drawText(x,y) 这个y并不是text的左上角，而是以baseline为基准的。
        mPaint.setColor(Color.RED);
        //canvas.drawText(str, 0, top - fontMetrics.top, mPaint);
        float middleLine = top - (fontMetrics.top + fontMetrics.bottom) / 2;
        canvas.drawText(str, 0, middleLine, mPaint);

        //这两个和上面类是的
        mPaint.ascent();
        mPaint.descent();

    }
}
