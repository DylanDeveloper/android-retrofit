package app.dgandroid.eu.androidretrofit.Utils;

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
        Drawable drawable;
        int resourceId;
        WeatherCondition weatherCondition = WeatherCondition.valueOf(strWeatherCondition);
        switch (weatherCondition) {
            case Thunderstorm:
                Logger.i("Thunderstorm");
                resourceId = context.getResources().getIdentifier("a11n", "drawable", context.getPackageName());
                drawable = context.getResources().getDrawable(resourceId);
                break;
            case Drizzle:
                Logger.i("Drizzle");
                drawable = null;
                break;
            case Rain:
                Logger.i("Rain");
                resourceId = context.getResources().getIdentifier("a09n", "drawable", context.getPackageName());
                drawable = context.getResources().getDrawable(resourceId);
                break;
            case Snow:
                Logger.i("Snow");
                resourceId = context.getResources().getIdentifier("a13n", "drawable", context.getPackageName());
                drawable = context.getResources().getDrawable(resourceId);
                break;
            case Atmosphere:
                Logger.i("Atmosphere");
                drawable = null;
                break;
            case Clear:
                Logger.i("Clear");
                resourceId = context.getResources().getIdentifier("a01d", "drawable", context.getPackageName());
                drawable = context.getResources().getDrawable(resourceId);
                break;
            case Clouds:
                Logger.i("Clouds");
                resourceId = context.getResources().getIdentifier("a03d", "drawable", context.getPackageName());
                drawable = context.getResources().getDrawable(resourceId);
                break;
            case Extreme:
                Logger.i("Extreme");
                drawable = null;
                break;
            case Additional:
                Logger.i("Additional");
                drawable = null;
                break;
            default:
                Logger.i("default");
                drawable = null;
                break;
        }
        if(drawable == null){
            resourceId = context.getResources().getIdentifier("a01d", "drawable", context.getPackageName());
            drawable = context.getResources().getDrawable(resourceId);
        }
        return drawable;
    }
}