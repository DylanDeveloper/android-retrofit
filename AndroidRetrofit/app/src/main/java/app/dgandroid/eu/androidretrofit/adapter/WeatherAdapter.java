package app.dgandroid.eu.androidretrofit.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.util.List;
import app.dgandroid.eu.androidretrofit.R;
import app.dgandroid.eu.androidretrofit.databinding.ListItemBinding;
import app.dgandroid.eu.androidretrofit.model.Day;
import app.dgandroid.eu.androidretrofit.viewmodel.ItemDayViewModel;

/**
 * Created by Duilio on 20/04/2017.
 */

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {

    private List<Day> days;

    @Override
    public WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ListItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.list_item, parent, false);
        return new WeatherViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(WeatherViewHolder holder, int position) {
        ListItemBinding binding = holder.binding;
        binding.setItem(new ItemDayViewModel(days.get(position)));
    }

    @Override
    public int getItemCount() {
        return days.size();
    }

    public static class WeatherViewHolder extends RecyclerView.ViewHolder {
        private ListItemBinding binding;

        public WeatherViewHolder(ListItemBinding binding) {
            super(binding.weatherLayout);
            this.binding = binding;
        }
    }

    public WeatherAdapter(List<Day> days) {
        this.days = days;
    }
}