package com.example.xtest.generic.GenMaps;

public class Bounds
{
    public Northeast northeast;
    public Southwest southwest;

    public Bounds(Northeast northeast, Southwest southwest) {
        this.northeast = northeast;
        this.southwest = southwest;
    }

    public Northeast getNortheast() {
        return northeast;
    }

    public Southwest getSouthwest() {
        return southwest;
    }
}
