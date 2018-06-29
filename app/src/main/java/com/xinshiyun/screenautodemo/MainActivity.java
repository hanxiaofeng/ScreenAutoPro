package com.xinshiyun.screenautodemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.xinshiyun.screenautodemo.utils.AppUtils;
import com.xinshiyun.screenautodemo.utils.DensityUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置适配基准，一般以宽度适配，此处测试高度适配
        DensityUtils.setOrientation(this, AppUtils.HEIGHT);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        Button button = (Button) findViewById(R.id.btn_width);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,WidthAutoActivity.class));
            }
        });
    }
}
