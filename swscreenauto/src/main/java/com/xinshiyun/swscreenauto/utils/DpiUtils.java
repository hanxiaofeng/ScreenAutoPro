package com.xinshiyun.swscreenauto.utils;

import android.content.Context;

/**
 * author: 王可可
 * Created on 2018/7/5.
 * description: 摇摇摆摆又是一年
 */

public class DpiUtils {

    public static float getXdpi(Context context) {
        float xdpi = context.getResources().getDisplayMetrics().xdpi;
        return xdpi;
    }

    public static float getYdpi(Context context) {
        float ydpi = context.getResources().getDisplayMetrics().ydpi;
        return ydpi;
    }

    public static float getDensityDpi(Context context) {
        float densityDpi = context.getResources().getDisplayMetrics().densityDpi;
        return densityDpi;
    }

    public static float getDensity(Context context) {
        float density = context.getResources().getDisplayMetrics().density;
        return density;
    }

    public static String getXXXXdpi(Context context) {
        float xdpi = context.getResources().getDisplayMetrics().xdpi;
        return getDpi(xdpi);
    }

    /**
     * @return :
     * @Description:匹配得到手机的dpi
     * @author 作者 :likun
     * @date 创建时间：2016/6/24 16:07
     * @parameter :
     */
    public static String getDpi(float xdpi) {
        String dpi = "";
        if (xdpi >= 0 && xdpi < 120) {
            dpi = "ldpi";
        } else if (xdpi >= 120 && xdpi < 160) {
            dpi = "mdpi";
        } else if (xdpi >= 160 && xdpi < 240) {
            dpi = "hdpi";
        } else if (xdpi >= 240 && xdpi < 320) {
            dpi = "xhdpi";
        } else if (xdpi >= 320 && xdpi < 480) {
            dpi = "xxhdpi";
        } else if (xdpi >= 480 && xdpi < 640) {
            dpi = "xxxhdpi";
        }
        return dpi;
    }

}
