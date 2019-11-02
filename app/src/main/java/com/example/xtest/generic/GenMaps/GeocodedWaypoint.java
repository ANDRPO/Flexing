package com.example.xtest.generic.GenMaps;

import java.util.List;

public class GeocodedWaypoint
{
    public String geocoder_status;
    public String place_id;
    public List<String> types;

    public GeocodedWaypoint(String geocoder_status, String place_id, List<String> types) {
        this.geocoder_status = geocoder_status;
        this.place_id = place_id;
        this.types = types;
    }

    public String getGeocoder_status() {
        return geocoder_status;
    }

    public String getPlace_id() {
        return place_id;
    }

    public List<String> getTypes() {
        return types;
    }
}
