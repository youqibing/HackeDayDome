package com.example.dell.hackedaydome.Module.Module_Login;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.birbit.android.jobqueue.JobManager;
import com.example.dell.hackedaydome.HackeDayDomeApplication;
import com.example.dell.hackedaydome.Module.Module_Login.job_and_result.LoginJob;
import com.example.dell.hackedaydome.Module.Module_Main.MainActivity;
import com.example.dell.hackedaydome.R;
import com.example.dell.hackedaydome.Utils.ScreenUtil;

import de.greenrobot.event.EventBus;

/**
 * Created by dell on 2016/10/29.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText name_edt;
    private EditText password_edt;

    private ImageView register_img;
    private ImageView login_img;

    private JobManager jobManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setImmerseLayout(findViewById(R.id.activity_login));

        initView();

        jobManager = HackeDayDomeApplication.getInstance().getJobManager();
        //EventBus.getDefault().register(this);
    }

    public void initView(){
        name_edt = (EditText)findViewById(R.id.name_edt);
        password_edt = (EditText)findViewById(R.id.password_edt);

        register_img = (ImageView)findViewById(R.id.registe_img);
        register_img.setOnClickListener(this);
        login_img = (ImageView)findViewById(R.id.login_img);
        login_img.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_img:
                String name = name_edt.getText().toString();
                String passWord = password_edt.getText().toString();

                startActivity(new Intent(this,MainActivity.class));
                /*
                if(passWord.length() >= 6 && passWord.length() <= 12){
                    login(name,passWord);
                }else {
                    Toast.makeText(this,"密码格式有误,请检查密码长度是否为6-12位",Toast.LENGTH_LONG).show();
                }
                */
                break;
            case R.id.registe_img:
                startActivity(new Intent(this,RegisterActivity.class));
                break;
        }
    }

    public void login(String name,String passWord){
        jobManager.addJobInBackground(new LoginJob(name,passWord));
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
