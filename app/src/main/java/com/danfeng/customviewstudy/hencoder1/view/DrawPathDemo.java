package com.danfeng.customviewstudy.hencoder1.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by D22400 on 2018/7/17.
 * Email:danfeng.qiu@ck-telecom.com
 * Describe:
 */

public class DrawPathDemo extends View {

    private Paint mPaint;

    private int mDefaultWidth = 300;
    private int mDefaultHeight = 300;
    private Path mPath;

    public DrawPathDemo(Context context) {
        this(context, null, 0);
    }

    public DrawPathDemo(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawPathDemo(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPath = new Path();
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
        } else if (heightMeasureMode != MeasureSpec.EXACTLY) {
            setMeasuredDimension(mDefaultWidth, heightMeasureSize);
        } else {
            setMeasuredDimension(widthMeasureSize, heightMeasureSize);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPath.moveTo(0, 0);
//        mPath.quadTo(0, 150, 300, 150);
        mPath.lineTo(100, 100);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mPath.arcTo(100, 100, 300, 300, 0, -90, true);
        }
        mPath.close();
        canvas.drawPath(mPath, mPaint);

    }
}
