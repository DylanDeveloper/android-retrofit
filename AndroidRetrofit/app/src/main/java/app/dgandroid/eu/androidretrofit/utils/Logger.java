package app.dgandroid.eu.androidretrofit.utils;

import android.util.Log;

/**
 * Created by Duilio on 11/04/2017.
 */

public class Logger {

    public static void i(String msg) {
        if (Config.DEBUG){
            Log.println(Log.INFO, getTag(), msg);
        }
    }

    public static void e(String msg) {
        if (Config.DEBUG){
            Log.println(Log.ERROR, getTag(), msg);
        }
    }

    private static String getTag() {
        String className = new Exception().getStackTrace()[2].getClassName();
        return className.substring(1 + className.lastIndexOf('.'));
    }
}