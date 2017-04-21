package app.dgandroid.eu.androidretrofit.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import app.dgandroid.eu.androidretrofit.Model.Day;
import app.dgandroid.eu.androidretrofit.R;
import app.dgandroid.eu.androidretrofit.Utils.Utility;

public class DayDetailsActivity extends AppCompatActivity {

    private TextView max, min, main, description, humidity, clouds, speed;
    private TextView dayNumber, monthText, dayText;
    private ImageView imageDay;
    private Day day;
    private Intent intentExtra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_details);

        dayNumber   = (TextView) findViewById(R.id.dayNumber);
        monthText   = (TextView) findViewById(R.id.monthText);
        dayText     = (TextView) findViewById(R.id.dayText);
        max         = (TextView) findViewById(R.id.max);
        min         = (TextView) findViewById(R.id.min);
        main        = (TextView) findViewById(R.id.main);
        description = (TextView) findViewById(R.id.description);
        humidity    = (TextView) findViewById(R.id.humidity);
        clouds      = (TextView) findViewById(R.id.clouds);
        speed       = (TextView) findViewById(R.id.speed);
        imageDay    = (ImageView) findViewById(R.id.imageDay);

        intentExtra = getIntent();
        this.day = (Day) intentExtra.getSerializableExtra("day");

        max.setText(""+day.getTemperatures().getMax());
        min.setText(""+day.getTemperatures().getMin());
        main.setText(day.getWeathers().get(0).getMain());
        description.setText(day.getWeathers().get(0).getDescription());
        humidity.setText("Humidity: " + day.getHumidity());
        clouds.setText("Clouds: " + day.getClouds());
        speed.setText("Speed: "+day.getSpeed());
        imageDay.setImageDrawable(Utility.getIcon(this, day.getWeathers().get(0).getIcon()));

        String dateDayNumber    = Utility.getTypeDateUnit(day.getDt(), Utility.DAY_NUMBER);
        String dateDayText      = Utility.getTypeDateUnit(day.getDt(), Utility.DAY_TEXT);
        String monthDayText      = Utility.getTypeDateUnit(day.getDt(), Utility.MONTH_TEXT);
        dayNumber.setText(dateDayNumber);
        dayText.setText(dateDayText);
        monthText.setText(monthDayText);
    }
}
