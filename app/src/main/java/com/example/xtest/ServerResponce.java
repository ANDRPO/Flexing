package com.example.xtest;

import com.google.gson.annotations.SerializedName;

public class ServerResponce<T> {

    @SerializedName("data")
    public T data;

    public Boolean success;

    public ServerResponce(T data, Boolean success) {
        this.data = data;
        this.success = success;
    }

    public Boolean getSuccess() {
        return success;
    }
}
