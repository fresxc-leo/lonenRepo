package com.exm.zhl.squirrel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FrameLayout frame = (FrameLayout)findViewById(R.id.mylayout);
        final Kagirl kag = new Kagirl(MainActivity.this);
        kag.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                kag.bitmapX = motionEvent.getX() - 150;
                kag.bitmapY = motionEvent.getY() - 150;
                kag.invalidate();
                return true;
            }
        });
        frame.addView(kag);
    }
}
