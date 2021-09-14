package com.fahemaSultana.uniclubz;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {

    public static Context applicationContext;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = getApplicationContext();
    }

    public static Context getAppContext() {
        return applicationContext;
    }

}
