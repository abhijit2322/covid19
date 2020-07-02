package com.abhijit.covid19map.Retrofit;

import com.abhijit.covid19map.service.ApiServices;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String BASE_URL = "https://owndb.herokuapp.com/covid-19/";
    private static Retrofit retrofit = null;
    public static ApiServices getApiService() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RetryCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit.create(ApiServices.class);
    }
}