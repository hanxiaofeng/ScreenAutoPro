package com.xinshiyun.swscreenauto;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.TextView;

import com.xinshiyun.swscreenauto.utils.DpiUtils;

public class MainActivity extends AppCompatActivity {

    private TextView tvShowDpi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        initView();
    }

    private void initView() {
        tvShowDpi = (TextView) findViewById(R.id.tv_show_dpi);

        WindowManager wm = (WindowManager) this
                .getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();


        float xdpi = DpiUtils.getXdpi(this);
        float ydpi = DpiUtils.getYdpi(this);
        String xxdpi = DpiUtils.getXXXXdpi(this);
        float densityDpi = DpiUtils.getDensityDpi(this);
        float density = DpiUtils.getDensity(this);

        String baseDpi = ""+getResources().getDimensionPixelSize(R.dimen.base_dpi)/density;


        tvShowDpi.setText("density = " + density + "\n"
                + "width*height = " + width+"*"+height + "\n"
                + "xxdpi = " + xxdpi + "\n"
                +"  baseDpi = "+baseDpi+ "\n"
                +"  densityDpi = "+densityDpi
        );




    }
}
