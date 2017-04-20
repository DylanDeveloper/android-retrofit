package app.dgandroid.eu.androidretrofit.Rest;

import app.dgandroid.eu.androidretrofit.Utils.ConfigurationConstants;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Duilio on 19/04/2017.
 */

public class Client {

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(ConfigurationConstants.URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}