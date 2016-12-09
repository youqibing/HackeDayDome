package com.example.dell.hackedaydome.Module.Module_Mine;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.hackedaydome.R;
import com.example.dell.hackedaydome.Utils.ScreenUtil;

/**
 * Created by dell on 2016/10/29.
 */

public class MineActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView back_img;
    private TextView colloection_tx;
    private TextView message_tx;
    private TextView suggestion_tx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine);
        setImmerseLayout(findViewById(R.id.mine_bacgroud));

        initView();
    }

    public void initView(){
        back_img = (ImageView)findViewById(R.id.back);
        colloection_tx = (TextView)findViewById(R.id.my_collection);
        message_tx = (TextView)findViewById(R.id.my_message);
        suggestion_tx = (TextView)findViewById(R.id.suggestion);

        back_img.setOnClickListener(this);
        colloection_tx.setOnClickListener(this);
        message_tx.setOnClickListener(this);
        suggestion_tx.setOnClickListener(this);

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
                break;
            case R.id.my_collection:
                startActivity(new Intent(this,MinePostActivity.class));
                break;
            case R.id.my_message:
                break;
            case R.id.suggestion:
                break;
        }
    }
}
