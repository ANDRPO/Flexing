package com.example.xtest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MapsJson {
    private static MapsJson mInstance;
    private Retrofit retrofit;
    private String BASE_URL = "https://google.ru/";

    public static MapsJson getInstance(){
        if(mInstance == null)
            mInstance = new MapsJson();
        return mInstance;
    }

    public MapsJson(){
        this.retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public Api getApi(){
        return retrofit.create(Api.class);
    }
}
