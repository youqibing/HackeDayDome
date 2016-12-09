package com.example.dell.hackedaydome.Module.Module_Main;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.dell.hackedaydome.DBOpenHelper;
import com.example.dell.hackedaydome.Module.Module_Mine.MineActivity;
import com.example.dell.hackedaydome.Module.Module_hot.HotFragment;
import com.example.dell.hackedaydome.Module.Module_new.NewFragment;
import com.example.dell.hackedaydome.R;
import com.example.dell.hackedaydome.Utils.ScreenUtil;

import greendao.GoodsDao;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private GoodsDao goodsDao;
    private HotFragment hotFragment;
    private NewFragment newFragment;
    private boolean ishot;

    private ImageView hot_or_mine_img;
    private ImageView mine_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setImmerseLayout(findViewById(R.id.activity_main));

        goodsDao = DBOpenHelper.getInstance().getDaoSession().getGoodsDao();

        initView();

    }

    public void initView(){

        hot_or_mine_img = (ImageView)findViewById(R.id.imageView_hot_or_new);
        hot_or_mine_img.setOnClickListener(this);
        mine_img = (ImageView)findViewById(R.id.imageView_mine) ;
        mine_img.setOnClickListener(this);

        hotFragment = new HotFragment();
        newFragment = new NewFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.comment_fragment_container,hotFragment).commit();
        hot_or_mine_img.setImageResource(R.mipmap.hot_movies);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageView_hot_or_new:
                if(ishot){
                    hot_or_mine_img.setImageResource(R.mipmap.hot_movies);
                    getSupportFragmentManager().beginTransaction().replace(R.id.comment_fragment_container,hotFragment).commit();
                    ishot = false;
                }else {
                    hot_or_mine_img.setImageResource(R.mipmap.new_movies);
                    getSupportFragmentManager().beginTransaction().replace(R.id.comment_fragment_container,newFragment).commit();
                    ishot = true;
                }
                break;
            case R.id.imageView_mine:
                startActivity(new Intent(this, MineActivity.class));
                break;
        }
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
}
