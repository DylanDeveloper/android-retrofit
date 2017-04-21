package app.dgandroid.eu.androidretrofit.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;
import app.dgandroid.eu.androidretrofit.Activities.DayDetailsActivity;
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
    public void onBindViewHolder(final WeatherViewHolder holder, final int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DayDetailsActivity.class);
                Day day = days.get(position);
                intent.putExtra("day", day);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public void onBindViewHolder(WeatherViewHolder holder, int position) {
        int max                 = (int)days.get(position).getTemperatures().getMax();
        int min                 = (int)days.get(position).getTemperatures().getMin();
        String dateDayNumber    = Utility.getTypeDateUnit(days.get(position).getDt(), Utility.DAY_NUMBER);
        String dateDayText      = Utility.getTypeDateUnit(days.get(position).getDt(), Utility.DAY_TEXT);
        holder.dayNumber.setText(dateDayNumber);
        holder.dayText.setText(dateDayText);
        holder.tempMax.setText("Max: "+max);
        holder.tempMin.setText("Min: "+min);
        holder.main.setText(days.get(position).getWeathers().get(0).getMain());
        holder.icon.setImageDrawable(Utility.getIcon(context, days.get(position).getWeathers().get(0).getIcon()));
    }

    @Override
    public int getItemCount() {
        return days.size();
    }

    public static class WeatherViewHolder extends RecyclerView.ViewHolder {

        LinearLayout weatherLayout;
        TextView main;
        ImageView icon;
        TextView tempMax;
        TextView tempMin;
        TextView dayNumber;
        TextView dayText;

        public WeatherViewHolder(View itemView) {
            super(itemView);
            weatherLayout   = (LinearLayout) itemView.findViewById(R.id.weather_layout);
            main            = (TextView) itemView.findViewById(R.id.main);
            icon            = (ImageView) itemView.findViewById(R.id.icon);
            tempMax         = (TextView) itemView.findViewById(R.id.temp_max);
            tempMin         = (TextView) itemView.findViewById(R.id.temp_min);
            dayNumber       = (TextView) itemView.findViewById(R.id.dayNumber);
            dayText         = (TextView) itemView.findViewById(R.id.dayText);
        }
    }

    public WeatherAdapter(List<Day> days, int rowLayout, Context context) {
        this.days       = days;
        this.rowLayout  = rowLayout;
        this.context    = context;
    }
}