package app.dgandroid.eu.androidretrofit.Model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by Duilio on 20/04/2017.
 */

public class Day {
    @SerializedName("weather")
    private List<Weather> weathers;
    @SerializedName("dt")
    private int dt;
    @SerializedName("pressure")
    private float pressure;
    @SerializedName("humidity")
    private int humidity;
    @SerializedName("speed")
    private float speed;
    @SerializedName("deg")
    private int deg;
    @SerializedName("clouds")
    private int clouds;

    public Day(List<Weather> weathers, int dt, float pressure, int humidity, float speed, int deg, int clouds){
        this.weathers   = weathers;
        this.dt         = dt;
        this.deg        = deg;
        this.pressure   = pressure;
        this.humidity   = humidity;
        this.speed      = speed;
        this.clouds     = clouds;
    }

    public List<Weather> getWeathers() {
        return weathers;
    }

    public void setWeathers(List<Weather> weathers) {
        this.weathers = weathers;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getClouds() {
        return clouds;
    }

    public void setClouds(int clouds) {
        this.clouds = clouds;
    }

    public int getDeg() {
        return deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }
}