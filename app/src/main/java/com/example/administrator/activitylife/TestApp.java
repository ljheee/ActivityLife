package com.example.administrator.activitylife;

import android.app.Application;
import android.util.Log;

/**
 * Application是Activity[整个活动]的起点
 * 如果不写该类，系统会启动一个默认的
 * Created by Administrator on 2016/8/23.
 */
public class TestApp extends Application {

    static  final  String TAG = "Application";
    @Override
    public void onCreate() {
        super.onCreate();


        Log.d(TAG, "OnCreate");

        init();
    }

    private void init() {
        Log.d(TAG, "init");
    }
}
