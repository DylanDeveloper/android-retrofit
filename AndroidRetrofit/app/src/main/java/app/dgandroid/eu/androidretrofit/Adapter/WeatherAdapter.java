package app.dgandroid.eu.androidretrofit.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;
import app.dgandroid.eu.androidretrofit.Model.Day;
import app.dgandroid.eu.androidretrofit.R;
import app.dgandroid.eu.androidretrofit.Utils.Utility;

/**
 * Created by Duilio on 20/04/2017.
 */

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {

    private List<Day> days;
    private int rowLayout;
    private Context context;

    @Override
    public WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new WeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WeatherViewHolder holder, int position) {
        holder.main.setText(days.get(position).getWeathers().get(0).getMain());
        holder.description.setText(days.get(position).getWeathers().get(0).getDescription());
        holder.icon.setImageDrawable(Utility.getIcon(context, days.get(position).getWeathers().get(0).getIcon()));
        holder.clouds.setText("Clouds: "+days.get(position).getClouds());
        holder.humidity.setText("Humidity: "+days.get(position).getHumidity());
        holder.speed.setText("Speed: "+days.get(position).getSpeed());
    }

    @Override
    public int getItemCount() {
        return days.size();
    }

    public static class WeatherViewHolder extends RecyclerView.ViewHolder {

        LinearLayout weatherLayout;
        TextView main;
        TextView description;
        TextView clouds;
        TextView speed;
        ImageView icon;
        TextView humidity;

        public WeatherViewHolder(View itemView) {
            super(itemView);
            weatherLayout   = (LinearLayout) itemView.findViewById(R.id.weather_layout);
            main            = (TextView) itemView.findViewById(R.id.main);
            description     = (TextView) itemView.findViewById(R.id.description);
            icon            = (ImageView) itemView.findViewById(R.id.icon);
            clouds          = (TextView) itemView.findViewById(R.id.clouds);
            speed           = (TextView) itemView.findViewById(R.id.speed);
            humidity        = (TextView) itemView.findViewById(R.id.humidity);
        }
    }

    public WeatherAdapter(List<Day> days, int rowLayout, Context context) {
        this.days       = days;
        this.rowLayout  = rowLayout;
        this.context    = context;
    }
}