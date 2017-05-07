package com.huangjifeng.paint;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.huangjifeng.paint.example.ProgressView;

import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private Timer mTimer;
    private int progressCount = 0;

    private ProgressView progressView;
    private MyHandler myHandler = new MyHandler(MainActivity.this);

    private static class MyHandler extends Handler {

        private final WeakReference<Activity> activityWeakReference;

        public MyHandler(Activity activity) {
            activityWeakReference = new WeakReference<Activity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            MainActivity mainActivity = (MainActivity) activityWeakReference.get();
            if (mainActivity.progressCount >= 100) {
                mainActivity.mTimer.cancel();
            }
            mainActivity.progressView.setProgress(mainActivity.progressCount);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTimer = new Timer();
        progressView = (ProgressView) findViewById(R.id.progress_view);
        progressView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startCount(v);
                v.setEnabled(false);
            }
        });

    }

    private void startCount(View v) {
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                Message message = myHandler.obtainMessage();
                progressCount += 2;
                myHandler.sendMessage(message);
            }
        }, 300, 300);
    }
}
