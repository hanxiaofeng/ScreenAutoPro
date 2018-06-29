package com.xinshiyun.screenautodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xinshiyun.screenautodemo.utils.AppUtils;
import com.xinshiyun.screenautodemo.utils.DensityUtils;

/**
 * 宽度适配
 */
public class WidthAutoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DensityUtils.setOrientation(this, AppUtils.WIDTH);
        setContentView(R.layout.activity_width_auto);
    }
}
