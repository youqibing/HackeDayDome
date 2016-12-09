package com.example.dell.hackedaydome.Module.Module_Login.job_and_result;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.birbit.android.jobqueue.Job;
import com.birbit.android.jobqueue.Params;
import com.birbit.android.jobqueue.RetryConstraint;

/**
 * Created by dell on 2016/10/29.
 */

public class LoginJob extends Job {
    String name;
    String password;

    private static final int UX = 4;

    public LoginJob(String name, String password) {
        super(new Params(UX).requireNetwork());

        this.name = name;
        this.password = password;
    }

    @Override
    public void onAdded() {

    }

    @Override
    public void onRun() throws Throwable {

    }

    @Override
    protected void onCancel(int cancelReason, @Nullable Throwable throwable) {

    }

    @Override
    protected RetryConstraint shouldReRunOnThrowable(@NonNull Throwable throwable, int runCount, int maxRunCount) {
        return null;
    }
}
