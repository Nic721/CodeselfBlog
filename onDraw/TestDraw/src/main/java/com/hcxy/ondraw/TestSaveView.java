package com.hcxy.ondraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by cxy on 2018/6/12.
 */

public class TestSaveView extends View {
    public TestSaveView(Context context) {
        super(context);
    }

    public TestSaveView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TestSaveView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public TestSaveView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.GREEN);
        Paint paint = new Paint();
        paint.setTextSize(60);
        paint.setColor(Color.BLUE);
        canvas.drawText("绿色部分为Canvas原本的区域",20,80,paint);

        canvas.save();

        Rect rect = new Rect(20,200,900,1000);
        canvas.clipRect(rect);
        canvas.drawColor(Color.YELLOW);
        paint.setColor(Color.BLACK);
        canvas.drawText("黄色部分为Layer区域",10,310,paint);

        canvas.restore();

        paint.setColor(Color.RED);
        canvas.drawText("canvas.restore()后绘制的文字",20,170,paint);
    }
}
