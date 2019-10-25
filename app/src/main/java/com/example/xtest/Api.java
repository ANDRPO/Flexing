package com.example.xtest;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {

    @POST("register")
    Call<JsonElement> registrationAPI(@Body String REG_JA);

    @GET("login")
    Call<JsonElement> authAPI(@Query("login") String login, @Query("password") String password);
}
