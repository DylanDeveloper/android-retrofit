package app.dgandroid.eu.androidretrofit.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/**
 * Created by Duilio on 20/04/2017.
 */

public class Weather implements Serializable {
    @SerializedName("main")
    public String main;
    @SerializedName("icon")
    public String icon;
}