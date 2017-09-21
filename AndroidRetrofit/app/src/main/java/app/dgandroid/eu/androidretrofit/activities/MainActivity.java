package app.dgandroid.eu.androidretrofit.activities;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;
import app.dgandroid.eu.androidretrofit.adapter.WeatherAdapter;
import app.dgandroid.eu.androidretrofit.databinding.ActivityMainBinding;
import app.dgandroid.eu.androidretrofit.model.WeatherResponse;
import app.dgandroid.eu.androidretrofit.R;
import app.dgandroid.eu.androidretrofit.rest.ActionCall;
import app.dgandroid.eu.androidretrofit.utils.Logger;

public class MainActivity extends AppCompatActivity {

    private String CITY = "Saint Petersburg";
    private ActivityMainBinding binding;
    private ActionCall actionCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.weatherRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        actionCall = new ActionCall(this, CITY, new ActionCall.ActionDelegate() {
            @Override
            public void onSuccess(WeatherResponse weatherResponse) {
                binding.weatherRecyclerView.setAdapter(new WeatherAdapter(weatherResponse.listDays));
            }
            @Override
            public void onFailure(Object t) {
                Logger.e(t.toString());
                Toast.makeText(getApplicationContext(), "Error = "+t.toString(), Toast.LENGTH_LONG).show();
            }
        });
        actionCall.execute();
    }
}