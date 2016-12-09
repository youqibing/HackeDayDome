package com.example.dell.hackedaydome;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import greendao.DaoMaster;
import greendao.DaoSession;

/**
 * Created by dell on 2016/10/27.
 */

public class DBOpenHelper {
    private static DBOpenHelper instance;
    private DaoSession daoSession;
    private DaoMaster daoMaster;
    private SQLiteDatabase db;

    private DBOpenHelper() {
        Context appContext = HackeDayDomeApplication.getInstance().getApplicationContext();
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(appContext, "ershoujie", null);
        db = devOpenHelper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public synchronized static DBOpenHelper getInstance() {
        if (instance == null) {
            instance = new DBOpenHelper();
        }
        return instance;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public DaoMaster getDaoMaster() {
        return daoMaster;
    }
}