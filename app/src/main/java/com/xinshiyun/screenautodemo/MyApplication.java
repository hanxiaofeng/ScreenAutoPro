package com.xinshiyun.screenautodemo;

import android.app.Application;

import com.xinshiyun.screenautodemo.utils.DensityUtils;

/**
 * author: 王可可
 * Created on 2018/6/26.
 * description: 摇摇摆摆又是一年
 */
public class MyApplication extends Application {

    private static MyApplication myApplication;


    public static MyApplication getInstance() {
        return myApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
        DensityUtils.setDensity(this);
    }

}
