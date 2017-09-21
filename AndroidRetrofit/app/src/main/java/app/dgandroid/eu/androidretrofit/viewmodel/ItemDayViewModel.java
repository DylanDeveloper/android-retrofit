package app.dgandroid.eu.androidretrofit.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;
import app.dgandroid.eu.androidretrofit.model.Day;
import app.dgandroid.eu.androidretrofit.utils.Utility;

/**
 * Created by Duilio on 21/09/2017.
 */

public class ItemDayViewModel extends BaseObservable {

    private Day day;
    private String imageUri;
    private String dateDayNumber;
    private String dateDayText;
    private String tempMorn;
    private String tempDay;
    private String tempEve;
    private String tempNight;
    private String main;

    public ItemDayViewModel(Day day) {
        this.day = day;
    }

    public String getDateDayNumber() {
        dateDayNumber = Utility.getTypeDateUnit(day.dt, Utility.DAY_NUMBER);
        String dateMonthNumber = Utility.getTypeDateUnit(day.dt, Utility.MONTH_NUMBER);
        return dateDayNumber+"/"+dateMonthNumber;
    }

    public String getDateDayText() {
        dateDayText = Utility.getTypeDateUnit(day.dt, Utility.DAY_TEXT);
        return dateDayText;
    }

    public String getMain() {
        main = day.weathers.get(0).main;
        return main;
    }

    public String getTempDay() {
        tempDay = ((int)day.temperatures.day)+ "°";
        return tempDay;
    }

    public String getTempEve() {
        tempEve = ((int)day.temperatures.eve)+ "°";
        return tempEve;
    }

    public String getTempMorn() {
        tempMorn = ((int)day.temperatures.morn)+ "°";
        return tempMorn;
    }

    public String getTempNight() {
        tempNight = ((int)day.temperatures.night)+ "°";
        return tempNight;
    }

    public String getImageUri() {
        imageUri = day.weathers.get(0).icon;
        return imageUri;
    }

    @BindingAdapter("android:background")
    public static void loadImage(ImageView view, String imageUri){
        view.setImageDrawable(Utility.getIcon(view.getContext(), imageUri));
    }
}