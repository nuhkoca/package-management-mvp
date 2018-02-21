package de.suitepad.packagelist;

import android.app.Application;

/**
 * Created by nuhkoca on 2/21/18.
 */

public class App extends Application {

    private static App instance;

    public static App getInstance(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
