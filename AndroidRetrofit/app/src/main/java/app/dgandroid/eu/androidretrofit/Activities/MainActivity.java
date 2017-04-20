package app.dgandroid.eu.androidretrofit.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.List;
import app.dgandroid.eu.androidretrofit.Adapter.WeatherAdapter;
import app.dgandroid.eu.androidretrofit.Model.Day;
import app.dgandroid.eu.androidretrofit.Model.WeatherResponse;
import app.dgandroid.eu.androidretrofit.R;
import app.dgandroid.eu.androidretrofit.Rest.ApiInterface;
import app.dgandroid.eu.androidretrofit.Rest.Client;
import app.dgandroid.eu.androidretrofit.Utils.Config;
import app.dgandroid.eu.androidretrofit.Utils.Logger;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private String CITY = "Saint Petersburg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("This Week Weather");

        recyclerView = (RecyclerView) findViewById(R.id.weather_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiInterface = Client.getClient().create(ApiInterface.class);
        Call<WeatherResponse> call = apiInterface.getWeatherDays(CITY, Config.DAYS, Config.APP_KEY);
        setTitle("7 Days Weather in " + CITY);
        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                int statusCode = response.code();
                Logger.i("statusCode = " + statusCode);
                if(statusCode == 200){
                    List<Day> days = response.body().getListDays();
                    Logger.i("weathers = " + days.size());
                    recyclerView.setAdapter(new WeatherAdapter(days, R.layout.list_item, getApplicationContext()));
                }
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                Logger.e(t.toString());
            }
        });
    }
}