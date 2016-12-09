package com.example.dell.hackedaydome.Module.Module_Main;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.dell.hackedaydome.R;
import com.example.dell.hackedaydome.Utils.ScreenUtil;
import com.example.dell.hackedaydome.View.VerticalAnimator;

/**
 * Created by dell on 2016/10/29.
 */

public class MoivesDetailActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView up_img;
    private ImageView down_img;

    private VerticalAnimator animator;
    private RelativeLayout animatorView;

    private ListView listView;
    private MoviesDetailAdapter moviesDetailAdapter;

    public boolean isShow = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moives_detail);
        setImmerseLayout(findViewById(R.id.movie_layout));

        initView();
    }

    public void initView(){
        up_img = (ImageView)findViewById(R.id.up_img);
        down_img = (ImageView)findViewById(R.id.down_img);
        listView = (ListView)findViewById(R.id.movie_list);

        moviesDetailAdapter = new MoviesDetailAdapter(this);
        listView.setAdapter(moviesDetailAdapter);

        up_img.setOnClickListener(this);
        down_img.setOnClickListener(this);

        animatorView = (RelativeLayout)findViewById(R.id.comment_layout);
        animator = new VerticalAnimator(animatorView,this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.down_img:
                if(isShow){
                    isShow = false;
                    animator.downView();
                }
                break;

            case R.id.up_img:
                if(!isShow){
                    isShow = true;
                    animator.upView();
                }
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
