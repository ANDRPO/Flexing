package com.example.xtest.generic.GenMaps;
import java.util.List;

public class Route
{
    public Bounds bounds;
    public String copyrights;
    public List<Leg> legs;
    public OverviewPolyline overview_polyline;
    public String summary;
    public List<Object> warnings;
    public List<Object> waypoint_order;

    public Route(Bounds bounds, String copyrights, List<Leg> legs, OverviewPolyline overview_polyline, String summary, List<Object> warnings, List<Object> waypoint_order) {
        this.bounds = bounds;
        this.copyrights = copyrights;
        this.legs = legs;
        this.overview_polyline = overview_polyline;
        this.summary = summary;
        this.warnings = warnings;
        this.waypoint_order = waypoint_order;
    }

    public Bounds getBounds() {
        return bounds;
    }

    public String getCopyrights() {
        return copyrights;
    }

    public List<Leg> getLegs() {
        return legs;
    }

    public OverviewPolyline getOverview_polyline() {
        return overview_polyline;
    }

    public String getSummary() {
        return summary;
    }

    public List<Object> getWarnings() {
        return warnings;
    }

    public List<Object> getWaypoint_order() {
        return waypoint_order;
    }
}
