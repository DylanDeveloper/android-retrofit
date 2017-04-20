package app.dgandroid.eu.androidretrofit.Rest;

import app.dgandroid.eu.androidretrofit.Model.WeatherResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Duilio on 19/04/2017.
 */

public interface ApiInterface {
    @GET("daily?")
    Call<WeatherResponse> getWeatherDays(@Query("q") String city, @Query("cnt") String countDays, @Query("APPID") String appID);
}
