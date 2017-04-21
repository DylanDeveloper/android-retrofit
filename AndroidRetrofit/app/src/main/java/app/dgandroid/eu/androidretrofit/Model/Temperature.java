package app.dgandroid.eu.androidretrofit.Model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/**
 * Created by Duilio on 21/04/2017.
 */

public class Temperature implements Serializable {

    @SerializedName("day")
    private float day;
    @SerializedName("min")
    private float min;
    @SerializedName("max")
    private float max;

    public Temperature(float day, float min, float max) {
        this.day    = day;
        this.min    = min;
        this.max    = max;
    }

    public float getDay() {
        return day;
    }

    public void setDay(float day) {
        this.day = day;
    }

    public float getMax() {
        return max;
    }

    public void setMax(float max) {
        this.max = max;
    }

    public float getMin() {
        return min;
    }

    public void setMin(float min) {
        this.min = min;
    }
}