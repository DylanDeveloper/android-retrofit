package app.dgandroid.eu.androidretrofit.rest;

import app.dgandroid.eu.androidretrofit.model.WeatherResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Duilio on 19/04/2017.
 */

public interface WeatherCallInterface {
    @GET("daily?")
    //http://api.openweathermap.org/data/2.5/forecast/daily?q=Palermo,it&cnt=8&APPID=b241c825823611967aaaa82711951620
    Call<WeatherResponse> getWeatherDays(@Query("q") String city, @Query("cnt") String countDays, @Query("units") String unitType , @Query("APPID") String appID);
}
