package com.hcxy.dispatchtouchevent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener,View.OnLongClickListener,View.OnClickListener{

    protected static final String TAG = "MyButton";
    private Button mIdMybtn1;
    private Button mIdMybtn2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mIdMybtn1 = findViewById(R.id.id_mybtn1);
        mIdMybtn2 = findViewById(R.id.id_mybtn2);
        mIdMybtn1.setOnTouchListener(this);
        mIdMybtn2.setOnLongClickListener(this);
        mIdMybtn2.setOnClickListener(this);


    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction();
        switch (action){
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG,"onTouch ACTION_DOWN");
                break;
            case MotionEvent.ACTION_HOVER_MOVE:
                Log.e(TAG,"onTouch ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG,"onTouch ACTION_UP");
                break;
            default:
                break;
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getApplicationContext(), "onclick",Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onLongClick(View v) {
        Toast.makeText(getApplicationContext(), "setOnLongClickListener",Toast.LENGTH_SHORT).show();
        return false;
    }
}
