package com.danfeng.customviewstudy.hencoder1.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by D22400 on 2018/7/19.
 * Email:danfeng.qiu@ck-telecom.com
 * Describe:
 */

public class UseShaderDemo extends View {

    private Paint mPaint;
    private int mDefaultWidth = 300;
    private int mDefaultHeight = 300;

    public UseShaderDemo(Context context) {
        this(context, null);
    }

    public UseShaderDemo(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public UseShaderDemo(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
//        Shader shader = new LinearGradient(0, 0, mDefaultWidth, mDefaultHeight, Color.parseColor("#E91E63"),
//                Color.parseColor("#2196F3"), Shader.TileMode.CLAMP);
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
//        canvas.drawCircle(mDefaultWidth/2, mDefaultWidth/2, mDefaultWidth/2, mPaint);
    }
}
