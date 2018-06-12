package com.hcxy.ondraw;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        drawOnBitmap();
    }

    private void initView() {
        mImageView = findViewById(R.id.imageView);
    }

    private void drawOnBitmap(){
        Bitmap bitmap = Bitmap.createBitmap(800,400,Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(Color.GREEN);

        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(60);
        canvas.drawText("hello, everyone",150,200,paint);

        mImageView.setImageBitmap(bitmap);
    }
}
