package com.xinshiyun.testautodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvShowDpi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置适配基准，一般以宽度适配，此处测试高度适配
        DensityUtils.setOrientation(this, AppUtils.WIDTH);
        setContentView(R.layout.activity_main);

        initView();
    }


    private void initView() {
        tvShowDpi = (TextView) findViewById(R.id.tv_show_dpi);


    }
}
