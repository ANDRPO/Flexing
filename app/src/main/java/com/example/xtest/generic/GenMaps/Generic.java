package com.example.xtest.generic.GenMaps;

import java.util.List;

public class Generic
{
    public List<GeocodedWaypoint> geocoded_waypoints;
    public List<Route> routes;
    public String status;

    public Generic(List<GeocodedWaypoint> geocoded_waypoints, List<Route> routes, String status) {
        this.geocoded_waypoints = geocoded_waypoints;
        this.routes = routes;
        this.status = status;
    }

    public List<GeocodedWaypoint> getGeocoded_waypoints() {
        return geocoded_waypoints;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public String getStatus() {
        return status;
    }
}

