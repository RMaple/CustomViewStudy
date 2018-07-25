package com.danfeng.customviewstudy.hencoder1.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by D22400 on 2018/7/25.
 * Email:danfeng.qiu@ck-telecom.com
 * Describe:
 */

public class TextPathDemo extends View {

    private Paint mPaint;
    private String text = "Hello World";
    private Path textPath = new Path();

    private int mDefaultWidth = 100;
    private int mDefaultHeight = 100;

    public TextPathDemo(Context context) {
        this(context, null, 0);
    }

    public TextPathDemo(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TextPathDemo(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setTextSize(120);
        mPaint.getTextPath(text,0,text.length(),0,100,textPath);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMeasureMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMeasureMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthMeasureSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMeasureSize = MeasureSpec.getSize(heightMeasureSpec);
        if (widthMeasureMode == MeasureSpec.AT_MOST && heightMeasureMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(mDefaultWidth, mDefaultHeight);
        } else if (widthMeasureMode != MeasureSpec.EXACTLY) {
            setMeasuredDimension(widthMeasureSize, mDefaultHeight);
        } else if (heightMeasureMode != MeasureSpec.EXACTLY){
            setMeasuredDimension(mDefaultWidth, heightMeasureSize);
        }else {
            setMeasuredDimension(widthMeasureSize, heightMeasureSize);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(textPath,mPaint);
    }
}
