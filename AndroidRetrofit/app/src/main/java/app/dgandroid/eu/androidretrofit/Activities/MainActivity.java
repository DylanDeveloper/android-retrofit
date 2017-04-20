package app.dgandroid.eu.androidretrofit.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import app.dgandroid.eu.androidretrofit.R;

public class MainActivity extends AppCompatActivity {

    private final static String API_KEY = "7e8f60e325cd06e164799af1e317d7a7";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
