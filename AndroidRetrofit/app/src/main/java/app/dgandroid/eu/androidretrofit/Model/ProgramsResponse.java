package app.dgandroid.eu.androidretrofit.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Duilio on 19/04/2017.
 */

public class ProgramsResponse {
    @SerializedName ("data")
    private String data;
    //http://api.openweathermap.org/data/2.5/forecast/daily?q=Palermo,it&cnt=8&APPID=b241c825823611967aaaa82711951620
}
