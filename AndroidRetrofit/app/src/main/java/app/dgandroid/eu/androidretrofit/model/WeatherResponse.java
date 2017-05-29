package app.dgandroid.eu.androidretrofit.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by Duilio on 19/04/2017.
 */

public class WeatherResponse {
    @SerializedName ("list")
    private List<Day> listDays;
    @SerializedName("message")
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Day> getListDays() {
        return listDays;
    }

    public void setListDays(List<Day> listDays) {
        this.listDays = listDays;
    }
}