package com.example.xtest;

import com.example.xtest.GettersAndSetters.GAS_news;
import com.example.xtest.generic.GenMaps.Generic;
import com.example.xtest.generic.GenMaps.GeocodedWaypoint;
import com.example.xtest.generic.GenMaps.Leg;
import com.example.xtest.generic.GenMaps.Route;
import com.example.xtest.generic.GenMaps.Step;
import com.example.xtest.generic.Login_F;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {
    @GET("maps/api/directions/json")
    Call<Generic> getRoute(@Query("origin") String position,
                           @Query("destination") String destination,
                           @Query("key") String key);

    @POST("register")
    Call<ServerResponse<Login_F>> registrationAPI(@Body Map map);

    @GET("login")
    Call<ServerResponse<Login_F>> authAPI(@Query("login") String login, @Query("password") String password);

    @GET("news")
    Call<ServerResponse<ArrayList<GAS_news>>> newsAPI();
}
