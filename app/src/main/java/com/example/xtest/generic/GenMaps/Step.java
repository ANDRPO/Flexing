package com.example.xtest.generic.GenMaps;

public class Step
{
    public Distance distance;
    public Duration duration;
    public EndLocation end_location;
    public String html_instructions;
    public Polyline polyline;
    public StartLocation start_location;
    public String travel_mode;

    public Step(Distance distance, Duration duration, EndLocation end_location, String html_instructions, Polyline polyline, StartLocation start_location, String travel_mode) {
        this.distance = distance;
        this.duration = duration;
        this.end_location = end_location;
        this.html_instructions = html_instructions;
        this.polyline = polyline;
        this.start_location = start_location;
        this.travel_mode = travel_mode;
    }

    public Distance getDistance() {
        return distance;
    }

    public Duration getDuration() {
        return duration;
    }

    public EndLocation getEnd_location() {
        return end_location;
    }

    public String getHtml_instructions() {
        return html_instructions;
    }

    public Polyline getPolyline() {
        return polyline;
    }

    public StartLocation getStart_location() {
        return start_location;
    }

    public String getTravel_mode() {
        return travel_mode;
    }
}
