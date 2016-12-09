package com.example.dell.hackedaydome;

import android.app.Application;
import android.content.Context;

import com.birbit.android.jobqueue.JobManager;
import com.birbit.android.jobqueue.config.Configuration;
import com.birbit.android.jobqueue.log.CustomLogger;

/**
 * Created by dell on 2016/10/27.
 */

public class HackeDayDomeApplication extends Application{
    private JobManager jobManager;

    private static Context context;
    private static HackeDayDomeApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();
        configureJobManager();
    }


    public HackeDayDomeApplication() {
        instance = this;
    }

    public static HackeDayDomeApplication getInstance() {
        return instance;
    }

    public static Context getContext(){     //获取RaisingPetsApplication类的上下文，由于我们在mainfinest中已经设置，
        return context;                                                  //所以这里的上下文就是整个APP的上下文。
    }

    public void configureJobManager(){
        Configuration configuration = new Configuration.Builder(this)
                .customLogger(new CustomLogger() {
                    private static final String TAG = "JOBS";

                    @Override
                    public boolean isDebugEnabled() {
                        return true;
                    }

                    @Override
                    public void d(String text, Object... args) {

                    }

                    @Override
                    public void e(Throwable t, String text, Object... args) {

                    }

                    @Override
                    public void e(String text, Object... args) {

                    }

                    @Override
                    public void v(String text, Object... args) {

                    }
                })
                .minConsumerCount(1)//always keep at least one consumer alive
                .maxConsumerCount(3)//up to 3 consumers at a time
                .loadFactor(3)//3 jobs per consumer
                .consumerKeepAlive(120)//wait 2 minute
                .build();
        jobManager = new JobManager(configuration);
    }

    public JobManager getJobManager(){
        return jobManager;
    }

}
