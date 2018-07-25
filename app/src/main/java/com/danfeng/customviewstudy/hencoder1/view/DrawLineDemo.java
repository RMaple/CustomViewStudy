package com.danfeng.customviewstudy.hencoder1.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by D22400 on 2018/7/16.
 * Email:danfeng.qiu@ck-telecom.com
 * Describe:
 */

public class DrawLineDemo extends View {

    private Paint mPaint;

    private float[] mLines = new float[]{0, 0, 20, 20, 40, 40, 50, 50};

    public DrawLineDemo(Context context) {
        this(context, null, 0);
    }

    public DrawLineDemo(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawLineDemo(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(10);
        canvas.drawLines(mLines, mPaint);
    }
}
