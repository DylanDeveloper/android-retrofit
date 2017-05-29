package app.dgandroid.eu.androidretrofit.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import java.util.Date;

/**
 * Created by Duilio on 20/04/2017.
 */

public class Utility {
    //Mon Apr 24 11:00:00 GMT+02:00 2017
    public static int DAY_TEXT      = 0;
    public static int MONTH_TEXT    = 1;
    public static int DAY_NUMBER    = 2;
    public static int YEAR_NUMBER   = 5;

    public enum WeatherCondition {
        Thunderstorm,
        Drizzle,
        Rain,
        Snow,
        Atmosphere,
        Clear,
        Clouds,
        Extreme,
        Additional;
    }

    public static String[] icons =
            {   "01d"
                ,"02d"
                ,"03d"
                ,"04d"
                ,"09d"
                ,"10d"
                ,"11d"
                ,"13d"
                ,"50d"
                ,"01n"
                ,"02n"
                ,"03n"
                ,"04n"
                ,"09n"
                ,"10n"
                ,"11n"
                ,"13n"
                ,"50n"
            };

    public static Drawable getIcon(Context context, String idIcon){
        int resourceId;
        Drawable drawable;
        for(int i=0; i<icons.length;i++){
            if(idIcon.equalsIgnoreCase(icons[i])){
                resourceId = context.getResources().getIdentifier("a"+idIcon, "drawable", context.getPackageName());
                drawable = context.getResources().getDrawable(resourceId);
                return drawable;
            }
        }
        resourceId = context.getResources().getIdentifier("a03d", "drawable", context.getPackageName());
        drawable = context.getResources().getDrawable(resourceId);
        return drawable;
    }

    public static String getTypeDateUnit(long dateTimeStamp, int TYPE){
        Date time = new Date(dateTimeStamp*1000);
        String timeStampString = time.toString();
        String[] timeStampArrayString = timeStampString.split(" ");
        return timeStampArrayString[TYPE];
    }

    public static Drawable getWeatherConditionBackground(Context context, String strWeatherCondition){ //Just for Testing
        Logger.i("strWeatherCondition = " + strWeatherCondition);
        Drawable drawable = null;
        int resourceId;
        WeatherCondition weatherCondition = WeatherCondition.valueOf(strWeatherCondition);
        switch (weatherCondition) {
            case Thunderstorm:
                resourceId = context.getResources().getIdentifier("a11n", "drawable", context.getPackageName());
                drawable = context.getResources().getDrawable(resourceId);
                break;
            case Drizzle:
                break;
            case Rain:
                resourceId = context.getResources().getIdentifier("a09n", "drawable", context.getPackageName());
                drawable = context.getResources().getDrawable(resourceId);
                break;
            case Snow:
                resourceId = context.getResources().getIdentifier("a13n", "drawable", context.getPackageName());
                drawable = context.getResources().getDrawable(resourceId);
                break;
            case Atmosphere:
                break;
            case Clear:
                resourceId = context.getResources().getIdentifier("a01d", "drawable", context.getPackageName());
                drawable = context.getResources().getDrawable(resourceId);
                break;
            case Clouds:
                resourceId = context.getResources().getIdentifier("a03d", "drawable", context.getPackageName());
                drawable = context.getResources().getDrawable(resourceId);
                break;
            case Extreme:
                break;
            case Additional:
                break;
            default:
                break;
        }
        if(drawable == null){
            resourceId = context.getResources().getIdentifier("a01d", "drawable", context.getPackageName());
            drawable = context.getResources().getDrawable(resourceId);
        }
        return drawable;
    }
}