package com.example.xtest;

import com.google.gson.annotations.SerializedName;

public class ServerResponce<T> {

    public T data;
    public Boolean success;

    public ServerResponce(Boolean success, T data) {
        this.data = data;
        this.success = success;
    }

    public Boolean getSuccess() {
        return success;
    }

    public T getData() {
        return data;
    }
}
