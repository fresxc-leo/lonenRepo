package com.exm.zhl.squirrel;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*        FrameLayout frame = (FrameLayout)findViewById(R.id.mylayout);
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
*/
        frame = (FrameLayout)findViewById(R.id.myframe);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0x123);
            }
        }, 0, 170);
    }
    FrameLayout frame = null;
    Handler handler = new Handler() {
        int i = 0;
        @Override
        public void handleMessage(Message msg) {
            if(msg.what == 0x123) {
                i++;
                move(i % 8);
            }
            super.handleMessage(msg);
        }
    };

    void move(int i)
    {
        Drawable a = ResourcesCompat.getDrawable(getResources(), R.drawable.s_1,null);
        Drawable b = ResourcesCompat.getDrawable(getResources(), R.drawable.s_2,null);
        Drawable c = ResourcesCompat.getDrawable(getResources(), R.drawable.s_3,null);
        Drawable d = ResourcesCompat.getDrawable(getResources(), R.drawable.s_4,null);
        Drawable e = ResourcesCompat.getDrawable(getResources(), R.drawable.s_5,null);
        Drawable f = ResourcesCompat.getDrawable(getResources(), R.drawable.s_6,null);
        Drawable g = ResourcesCompat.getDrawable(getResources(), R.drawable.s_7,null);
        Drawable h = ResourcesCompat.getDrawable(getResources(), R.drawable.s_8,null);
        switch (i)
        {
            case 0:
                frame.setForeground(a);
                break;
            case 1:
                frame.setForeground(b);
                break;
            case 2:
                frame.setForeground(c);
                break;
            case 3:
                frame.setForeground(d);
                break;
            case 4:
                frame.setForeground(e);
                break;
            case 5:
                frame.setForeground(f);
                break;
            case 6:
                frame.setForeground(g);
                break;
            case 7:
                frame.setForeground(h);
                break;
        }
    }
}
