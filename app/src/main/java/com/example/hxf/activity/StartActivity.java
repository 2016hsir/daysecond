package com.example.hxf.activity;

import android.app.Activity;
import android.os.Bundle;

import com.example.hxf.androidproject.R;

/**
 * Created by Administrator on 16-9-3.
 */
public class StartActivity  extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startpager);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finish();
            }
        }).start();

    }

}
