package app.dgandroid.eu.androidretrofit.Model;

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
    //"city":{},
    //"cod":"200",
    //"message":0.264864,
    //"cnt":8,
    //"list":[]

    //http://api.openweathermap.org/data/2.5/forecast/daily?q=Palermo,it&cnt=8&APPID=b241c825823611967aaaa82711951620

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