package com.danfeng.customviewstudy.hencoder1.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by D22400 on 2018/7/17.
 * Email:danfeng.qiu@ck-telecom.com
 * Describe:
 */

public class DrawArcDemo extends View {

    private Paint mPaint;

    private int mDefaultWidth = 200;
    private int mDefaultHeight = 200;

    public DrawArcDemo(Context context) {
        this(context, null);
    }

    public DrawArcDemo(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawArcDemo(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
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
        mPaint.setStyle(Paint.Style.FILL);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawArc(0, 0, 200, 200, -170, 30, false, mPaint);
            canvas.drawArc(0, 0, 200, 200, -120, 100, true, mPaint);
            canvas.drawArc(0, 0, 200, 200, 20, 140, false, mPaint);

        }
    }
}
