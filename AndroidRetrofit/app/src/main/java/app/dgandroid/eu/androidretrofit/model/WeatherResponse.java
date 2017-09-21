package app.dgandroid.eu.androidretrofit.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by Duilio on 19/04/2017.
 */

public class WeatherResponse {
    @SerializedName ("list")
    public List<Day> listDays;
}