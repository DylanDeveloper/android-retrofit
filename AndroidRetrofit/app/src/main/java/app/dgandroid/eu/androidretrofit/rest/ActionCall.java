package app.dgandroid.eu.androidretrofit.rest;

import android.content.Context;
import app.dgandroid.eu.androidretrofit.customs.ProgressLoading;
import app.dgandroid.eu.androidretrofit.model.WeatherResponse;
import app.dgandroid.eu.androidretrofit.utils.Config;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Duilio on 21/09/2017.
 */

public class ActionCall {

    private ProgressLoading loading;
    private Call<WeatherResponse> call;
    private ActionDelegate delegate;
    private String city;

    public ActionCall(Context context, String city, ActionDelegate delegate) {
        this.delegate       = delegate;
        this.city           = city;
        this.loading        = new ProgressLoading(context);
    }

    public void execute() {
        loading.onShow();
        WeatherCallInterface weatherCallInterface = Client.getClient().create(WeatherCallInterface.class);
        call = weatherCallInterface.getWeatherDays(city, Config.DAYS, Config.UNIT_TYPE, Config.APP_KEY);
        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                int statusCode = response.code();
                if(statusCode == Config.RESP_OK) {
                    delegate.onSuccess(response.body());
                } else {
                    delegate.onFailure("On Failure - " + statusCode);
                }
                loading.dismiss();
            }
            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                delegate.onFailure(t.getMessage());
                loading.dismiss();
            }
        });
    }

    public interface ActionDelegate {
        void onSuccess(WeatherResponse weatherResponse);
        void onFailure(Object t);
    }
}