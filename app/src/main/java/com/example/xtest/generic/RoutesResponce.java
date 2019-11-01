package com.example.xtest.generic;

import com.google.maps.android.geometry.Bounds;

public class RoutesResponce {
    public Bounds bounds;
    public String copyrights;
    public Legs legs;
    public Overview_polyline overview_polyline;
    public String summary;

    public RoutesResponce(Bounds bounds, String copyrights, Legs legs, Overview_polyline overview_polyline, String summary) {
        this.bounds = bounds;
        this.copyrights = copyrights;
        this.legs = legs;
        this.overview_polyline = overview_polyline;
        this.summary = summary;
    }

    public Bounds getBounds() {
        return bounds;
    }

    public String getCopyrights() {
        return copyrights;
    }

    public Legs getLegs() {
        return legs;
    }

    public Overview_polyline getOverview_polyline() {
        return overview_polyline;
    }

    public String getSummary() {
        return summary;
    }
}
