package com.hcxy.shape;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ShapeActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mRectangle;
    private Button mOval;
    private Button mLine;
    private Button mRing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shape);
        initView();
    }

    private void initView() {
        mRectangle = findViewById(R.id.rectangle);
        mOval = findViewById(R.id.oval);
        mLine = findViewById(R.id.line);
        mRing = findViewById(R.id.ring);
        mRectangle.setOnClickListener(this);
        mOval.setOnClickListener(this);
        mLine.setOnClickListener(this);
        mRing.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.rectangle:
                intent.setClass(this, RectangleActivity.class);
                break;
            case R.id.oval:
                intent.setClass(this,OvalActivity.class);
                break;
            case R.id.line:
                intent.setClass(this,LineActivity.class);
                break;
            case R.id.ring:
                intent.setClass(this,RingActivity.class);
                break;
            default:
                break;
        }
        startActivity(intent);
    }
}
