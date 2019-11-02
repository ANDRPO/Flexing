package com.example.xtest.generic.GenMaps;
import java.util.List;

public class Leg {
    public Distance distance;
    public Duration duration;
    public String end_address;
    public EndLocation end_location;
    public String start_address;
    public StartLocation start_location;
    public List<Step> steps;
    public List<Object> traffic_speed_entry;
    public List<Object> via_waypoint;

    public Leg(
            Distance distance,
            Duration duration,
            String end_address,
            EndLocation end_location,
            String start_address,
            StartLocation start_location,
            List<Step> steps,
            List<Object> traffic_speed_entry,
            List<Object> via_waypoint)
    {
        this.distance = distance;
        this.duration = duration;
        this.end_address = end_address;
        this.end_location = end_location;
        this.start_address = start_address;
        this.start_location = start_location;
        this.steps = steps;
        this.traffic_speed_entry = traffic_speed_entry;
        this.via_waypoint = via_waypoint;
    }

    public Distance getDistance() {
        return distance;
    }

    public Duration getDuration() {
        return duration;
    }

    public String getEnd_address() {
        return end_address;
    }

    public EndLocation getEnd_location() {
        return end_location;
    }

    public String getStart_address() {
        return start_address;
    }

    public StartLocation getStart_location() {
        return start_location;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public List<Object> getTraffic_speed_entry() {
        return traffic_speed_entry;
    }

    public List<Object> getVia_waypoint() {
        return via_waypoint;
    }
}
