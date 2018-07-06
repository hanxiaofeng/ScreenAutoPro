package com.xinshiyun.testautodemo;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;

import java.text.DecimalFormat;

/**
 * author: 王可可
 * Created on 2018/6/29.
 * description: 摇摇摆摆又是一年
 *
 *
 * 个人理解：拿到设计图后，尺寸除以2，xml指定测量后的值/2，单位为dp，如果使用原图，字体scaleDensity*2
 * 宽高只能以某个为适配基准，要么以宽为基准，要么以高为基准。
 *
 *
 * 比如：UI给的效果图为：1334*750，宽高除以2后为667，375，在setAppOrientation方法里设置宽高值667，375，
 * 在xml里通过markman测量的大小除以2，然后以dp为单位写死即可。
 */

public class DensityUtils {

    private static float appDensity;
    private static float appScaledDensity;
    private static DisplayMetrics appDisplayMetrics;

    public static void setDensity(@NonNull final Application application) {
        //获取application的DisplayMetrics
        appDisplayMetrics = application.getResources().getDisplayMetrics();

        if (appDensity == 0) {
            //初始化的时候赋值
            appDensity = appDisplayMetrics.density;
            appScaledDensity = appDisplayMetrics.scaledDensity;

            //添加字体变化的监听
            application.registerComponentCallbacks(new ComponentCallbacks() {
                @Override
                public void onConfigurationChanged(Configuration newConfig) {
                    //字体改变后,将appScaledDensity重新赋值
                    if (newConfig != null && newConfig.fontScale > 0) {
                        appScaledDensity = application.getResources().getDisplayMetrics().scaledDensity;
                    }
                }

                @Override
                public void onLowMemory() {
                }
            });
        }
    }




    //此方法在BaseActivity中做初始化(如果不封装BaseActivity的话,直接用下面那个方法就好了)
    public static void setDefault(Activity activity) {
        setAppOrientation(activity, AppUtils.WIDTH);
    }

    //此方法用于在某一个Activity里面更改适配的方向
    public static void setOrientation(Activity activity, String orientation) {
        setAppOrientation(activity, orientation);
    }

    /**
     * targetDensity
     * targetScaledDensity
     * targetDensityDpi
     * 这三个参数是统一修改过后的值
     * <p>
     * orientation:方向值,传入width或height
     */
    private static void setAppOrientation(@Nullable Activity activity, String orientation) {

        float targetDensity = 0;
        try {
            Double division;
            //根据带入参数选择不同的适配方向
            if (orientation.equals("height")) {
                division = division(appDisplayMetrics.heightPixels, 516);
            } else {
                division = division(appDisplayMetrics.widthPixels, 960);
            }
            //由于手机的长宽不尽相同,肯定会有除不尽的情况,有失精度,所以在这里把所得结果做了一个保留两位小数的操作
            DecimalFormat df = new DecimalFormat("0.00");
            String s = df.format(division);
            targetDensity = Float.parseFloat(s);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        float targetScaledDensity = targetDensity * (appScaledDensity / appDensity);
        int targetDensityDpi = (int) (160 * targetDensity);

        /**
         *
         * 最后在这里将修改过后的值赋给系统参数
         *
         * 只修改Activity的density值
         */

        DisplayMetrics activityDisplayMetrics = activity.getResources().getDisplayMetrics();
        activityDisplayMetrics.density = targetDensity;
        activityDisplayMetrics.scaledDensity = targetScaledDensity;
        activityDisplayMetrics.densityDpi = targetDensityDpi;
    }

    //除法
    public static final Double division(double a, double b) {
        double div = 0;
        if (b != 0) {
            div = a / b;
        } else {
            div = 0;
        }
        return div;
    }
}
