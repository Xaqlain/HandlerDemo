package com.example.handlerdemo;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private Handler  handler;

    private ProgressBar  progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progress = (ProgressBar) findViewById(R.id.progressBar1);

        handler =  new Handler();

    }

    public void onClicked()
    {
        super.onDestroy();
    }
    protected void onclick(Bundle savedInstanceState){}
    public void startProgress(View view) {
        Runnable runnable =  new Runnable() {
            public void run() {
                for (int i = 0; i <= 10; i++) {
                    final int value = i;
                    try {
                        Thread.sleep(1000);
                    }  catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler.post(new Runnable() {
                      public void run() {
                            progress.setProgress(value);
                        }
                    });
                }
            }
        };
        new Thread(runnable).start();
    }
}

