package com.example.xtest;

import com.example.xtest.GettersAndSetters.GAS_news;
import com.example.xtest.generic.Login_F;

import java.util.ArrayList;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {

    @POST("register")
    Call<ServerResponce<Login_F>> registrationAPI(@Body Map map);

    @GET("login")
    Call<ServerResponce<Login_F>> authAPI(@Query("login") String login, @Query("password") String password);

    @GET("news")
    Call<ServerResponce<ArrayList<GAS_news>>> newsAPI();
}
