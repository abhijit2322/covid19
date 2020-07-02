package com.abhijit.covid19map.service;

import com.abhijit.covid19map.model.WorldLatLang;
import com.abhijit.covid19map.model.IndiaData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiServices {

    @GET("getIndiaStatus")
    Call<List<IndiaData>> getIndiaData();

    @POST("getCountryLatLang")
    Call<List<WorldLatLang>> getCountrylatlng(@Body WorldLatLang worldLatLang);
}
