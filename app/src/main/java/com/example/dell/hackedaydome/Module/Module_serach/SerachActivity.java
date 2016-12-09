package com.example.dell.hackedaydome.Module.Module_serach;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.dell.hackedaydome.R;
import com.example.dell.hackedaydome.Utils.ScreenUtil;

/**
 * Created by dell on 2016/10/29.
 */

public class SerachActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView back_img;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvity_serach);
        setImmerseLayout(findViewById(R.id.activity_serach));

        back_img = (ImageView)findViewById(R.id.back);
        back_img.setOnClickListener(this);

    }

    protected void setImmerseLayout(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

            int statusBarHeight = ScreenUtil.getStatusBarHeight(this.getBaseContext());
            view.setPadding(0, statusBarHeight, 0, 0);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                this.finish();
        }
    }
}
