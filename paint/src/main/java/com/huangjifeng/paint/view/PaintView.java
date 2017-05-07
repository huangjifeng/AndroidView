package com.huangjifeng.paint.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2017/5/6.
 */

public class PaintView extends View {

    private final Context mContext;
    private Paint mPaint;

    public PaintView(Context context) {
        this(context, null);
    }

    public PaintView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        mPaint = new Paint();      //画笔初始化最好放这里面


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.reset();       //将画笔重置
        mPaint.setColor(Color.RED);     //给画笔设置颜色
        mPaint.setAlpha(255);           //设置透明度，255是完全不透明

        mPaint.setStyle(Paint.Style.STROKE);     //设置画笔的样式，描边，只画边界
        mPaint.setStrokeWidth(40);       //设置画笔的宽度，宽度是边界向里外扩散相同的厚度，即一半向里一半向外
        //mPaint.setStyle(Paint.Style.FILL);     //设置画笔的样式，全部填充，填充里面，不包括描边的厚度
        //mPaint.setStyle(Paint.Style.FILL_AND_STROKE);     //设置画笔的样式，里面填充和描边同时存在

        //线帽，指的是笔尖的形状，即两端的形状，比如进度条上可以使用，圆形的两端
        //mPaint.setStrokeCap(Paint.Cap.BUTT);     //线帽，没有，就是不会多出线帽
        mPaint.setStrokeCap(Paint.Cap.ROUND);     //线帽，圆形，会duo
        //mPaint.setStrokeCap(Paint.Cap.SQUARE);     //线帽，方形

        //线条交汇的地方的逻辑，什么形状
        //mPaint.setStrokeJoin(Paint.Join.BEVEL);     //直线
        //mPaint.setStrokeJoin(Paint.Join.MITER);    //锐角，指交汇的地方是一个角度
        //mPaint.setStrokeJoin(Paint.Join.ROUND);    //圆形，指交汇的地方是一段圆弧


        //canvas.drawCircle(600, 600, 100, mPaint);      //画圆

        //防锯齿，会损失一定的性能，对像素要就高，对每一个像素进行定位，所以影响性能
        mPaint.setAntiAlias(true);

        //设置是否使用图像抖动处理，会使绘制的图片等颜色更加的清晰以及饱满。也是损伤性能
        mPaint.setDither(true);

        /*Path path = new Path();
        path.moveTo(100, 100);
        path.lineTo(400, 100);
        path.lineTo(100, 400);
        mPaint.setStrokeJoin(Paint.Join.MITER);
        canvas.drawPath(path, mPaint);

        path.moveTo(100, 600);
        path.lineTo(400, 600);
        path.lineTo(400, 900);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        canvas.drawPath(path, mPaint);

        path.moveTo(100, 1100);
        path.lineTo(400, 1100);
        path.lineTo(300, 1300);
        mPaint.setStrokeJoin(Paint.Join.BEVEL);
        canvas.drawPath(path, mPaint);*/


        //------------------------文字绘制---------------------

        mPaint.getFontSpacing();  //获得字符行间距，即行与行之间的间距
        mPaint.getLetterSpacing();   //获得字符之间的间距
        mPaint.setLetterSpacing(4);  //设置字符之间的间距
        //设置文本删除线，即文本的字用一横杠删除
        mPaint.setStrikeThruText(true);
        mPaint.setUnderlineText(true);    //设置下划线
        mPaint.setTextSize(20);       //设置文本字体大小
        mPaint.getTextSize();     //获取文字字体大小
        mPaint.setTypeface(Typeface.DEFAULT_BOLD);  //设置字体类型
        //mPaint.setTypeface(Typeface.create())  //加载自定义字体
        mPaint.setTextSkewX(-0.25f);  //设置倾斜字体，官方推荐-0.25
        mPaint.setTextAlign(Paint.Align.LEFT);//文本对其方式，就是从该点开始从左往右开始画
        mPaint.setTextAlign(Paint.Align.LEFT);//文本对其方式，就是从该点开始从中间往两边开始画
        mPaint.setTextAlign(Paint.Align.LEFT);//文本对其方式，就是从该点开始从右往左开始画

        //计算指定长度的字符串（可以计算字符长度，字符个数，显示的时候真实的长度）
        String str = "我是haha";  //需要被计算的字符串
        float[] measureWidth = new float[1];
        //这个方法中将需要计算的字符串传进去，measureWidth获取到的是字符串的真实长度，返回值是字符的长度
        int breakText = mPaint.breakText(str, true, 200, measureWidth);
        //rect bounds    获取文本的矩形区域（宽高）
        //mPaint.getTextBounds(text, start, end, bounds);  //start:哪个字符开始   end：哪个字符结束，
        //获取文本的宽度，和上面类似，但是是一个比较粗略的结果
        mPaint.measureText(str);
        //获取文本的字符数量，和上面类似，但是比较精确，widths：是得到每一个字符的宽度，返回值是字符数
        //mPaint.getTextWidths(str,widths);





    }
}
