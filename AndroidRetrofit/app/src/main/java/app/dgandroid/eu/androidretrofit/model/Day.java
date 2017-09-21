package app.dgandroid.eu.androidretrofit.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Duilio on 20/04/2017.
 */

public class Day implements Serializable {
    @SerializedName("weather")
    public List<Weather> weathers;
    @SerializedName("temp")
    public Temperature temperatures;
    @SerializedName("dt")
    public long dt;
}