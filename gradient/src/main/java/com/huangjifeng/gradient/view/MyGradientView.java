package com.huangjifeng.gradient.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import com.huangjifeng.gradient.R;

/**
 * Paint画笔的高级技能
 * 渲染 Shader：
 * BimapShader         位图的图像渲染器
 * LinearGradient      线性渲染
 * RadialGradient      环形渲染
 * 水波纹效果，充电水波纹扩散效果、调色板
 * SweepGradient       梯度渲染(扫描渲染)
 * 微信等雷达扫描效果。手机卫士垃圾扫描
 * ComposeShader       组合渲染
 */

public class MyGradientView extends View {
    private final Context mContext;
    private Bitmap bitmap_01;
    private Paint mPaint;
    private BitmapShader bitmapShader;
    private int width;
    private int height;

    public MyGradientView(Context context) {
        this(context, null);
    }

    public MyGradientView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        bitmap_01 = BitmapFactory.decodeResource(getResources(), R.drawable.avatar3);
        mPaint = new Paint();
        width = bitmap_01.getWidth();
        height = bitmap_01.getHeight();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);  //将View全部填充这个设定的颜色

        //canvas.drawBitmap(bitmap_01, 0, 0, mPaint);


        /*
        * BimapShader         位图的图像渲染器
        *
        *
        * Shader.TileMode.CLAMP  : 拉伸最后一个像素去铺满剩下的地方
        * Shader.TileMode.MIRROR  ： 通过镜像翻转铺满剩下的地方
        * Shader.TileMode.REPEAT  ： 通过重复填充整个画面（电脑设置壁纸）
        * */
        //bitmapShader = new BitmapShader(bitmap_01, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        //mPaint.setShader(bitmapShader);
        //mPaint.setAntiAlias(true);

        //canvas.drawRect(new Rect(0, 0, 1000, 1000), mPaint);  //设置一个矩形填充,没填满的部分利用shader的规则进行填充
        //canvas.drawCircle(width / 2, height / 2, width / 2, mPaint);  //设置一个圆形，剩余的部分去除或者填充，按shaderde 规则

        //设置像素矩阵，来调整大小，为了解决宽高不一致的问题
        //float scale = Math.max(width, height) * 1.0f / Math.min(width, height);  //获取缩放比例
        //Matrix matrix = new Matrix();      //矩阵
        //matrix.setScale(scale, scale);      //缩放比例
        //bitmapShader.setLocalMatrix(matrix);
        //canvas.drawCircle(Math.max(width, height) / 2f, scale * Math.max(width, height) / 2, Math.max(width, height) / 2f, mPaint);



        /*
        * LinearGradient      线性渲染
        *
        * 线性渐变
        * x0,y0      起始点
        * x1,y1      结束点
        * int[] colors       中间依次要出现的几个颜色
        * float[] positions      数组大小和colors数组一样大，中间依次摆放的几个颜色分别放置在哪个位置上（参数比例从左往右）
        *
        * 可以做出选择选择器
        * */
        int[] colors = new int[]{Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW};
        LinearGradient linearGradient = new LinearGradient(0, 0, 400, 400, colors, null, Shader.TileMode.MIRROR);
        mPaint.setShader(linearGradient);
        //canvas.drawRect(new Rect(0, 0, 1000, 1000), mPaint);
        mPaint.setTextSize(200);
        canvas.drawText("abcdefg", 0, 600, mPaint);
    }
}
