package app.dgandroid.eu.androidretrofit.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/**
 * Created by Duilio on 21/04/2017.
 */

public class Temperature implements Serializable {
    @SerializedName("morn")
    public float morn;
    @SerializedName("eve")
    public float eve;
    @SerializedName("night")
    public float night;
    @SerializedName("day")
    public float day;
}