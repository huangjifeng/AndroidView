package com.huangjifeng.paint.example;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.huangjifeng.paint.R;

/**
 * 需求：自定义一个圆形进度条
 * <p>
 * 1、进度条底部的颜色
 * 2、进度条上面的颜色
 * 3、是否显示百分比
 * 4、进度条的宽度
 * 5、进度字体的颜色
 * 6、进度字体的大小
 * 7、是否是填满
 * 8、最大进度
 */

public class ProgressView extends View {
    private final Context mContext;
    private TypedArray mTypedArray;
    public static final int FILL = 1;
    public static final int STROKE = 0;
    private int backRoundColor;
    private int progressRoundColor;
    private boolean isShowProgress;
    private float progressWidth;
    private int max;
    private float redus;
    private float percent;

    private float progress;
    private int textColor;
    private int textSize;
    private int myStyle;
    private Paint mPaint;
    private int centerX;
    private int centerY;

    public float getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
        postInvalidate();
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }


    public ProgressView(Context context) {
        this(context, null);
    }

    public ProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        initAttrs(attrs);
        mPaint = new Paint();
    }

    private void initAttrs(AttributeSet attrs) {
        mTypedArray = mContext.obtainStyledAttributes(attrs, R.styleable.ProgressView);
        backRoundColor = mTypedArray.getColor(R.styleable.ProgressView_backRoundColor, Color.RED);
        progressRoundColor = mTypedArray.getColor(R.styleable.ProgressView_progressRoundColor, Color.BLUE);
        isShowProgress = mTypedArray.getBoolean(R.styleable.ProgressView_isShowProgress, false);
        progressWidth = mTypedArray.getDimension(R.styleable.ProgressView_progressWidth, 10);
        max = mTypedArray.getInteger(R.styleable.ProgressView_max, 100);
        textColor = mTypedArray.getColor(R.styleable.ProgressView_textColor, Color.GREEN);
        textSize = mTypedArray.getInteger(R.styleable.ProgressView_textSize, 15);
        myStyle = mTypedArray.getInteger(R.styleable.ProgressView_style, 0);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        centerX = getWidth() / 2;
        centerY = getHeight() / 2;
        redus = centerX - progressWidth / 2;
        percent = progress / max;
        drawBackRound(canvas);
        drawProgressRound(canvas);


    }

    private void drawProgressRound(Canvas canvas) {
        mPaint.reset();
        mPaint.setAntiAlias(true);
        mPaint.setColor(progressRoundColor);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(progressWidth);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        //RectF 和 Rect 的区别是精度不相同，要看使用的是int 还是 float
        RectF rectf = new RectF(centerX - redus, centerY - redus, centerX + redus, centerY + redus);
        Log.v("haha", "---handleMessage --  " + 360 * percent);
        canvas.drawArc(rectf, 0, 360 * percent, false, mPaint);
    }

    private void drawBackRound(Canvas canvas) {
        mPaint.setAntiAlias(true);
        mPaint.setColor(backRoundColor);
        mPaint.setStrokeWidth(progressWidth);
        mPaint.setStyle(Paint.Style.STROKE);

        canvas.drawCircle(centerX, centerY, redus, mPaint);
    }
}
