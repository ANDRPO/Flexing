package com.example.xtest.generic;

import com.google.gson.JsonObject;

import java.util.List;

public class MapsResponce<T> {
    public T routes;

    public MapsResponce(T routes, String error) {
        this.routes = routes;
        this.error_message = error;
    }

    public T getRoutes() {
        return routes;
    }

    public void setRoutes(T routes) {
        this.routes = routes;
    }

    public String getError() {
        return error_message;
    }

    public void setError(String error) {
        this.error_message = error;
    }

    public String error_message;

}
