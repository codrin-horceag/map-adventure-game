package com.collections;

import java.util.HashMap;
import java.util.Map;

public class Location {
    private final int LocationId;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationId, String description) {
        LocationId = locationId;
        this.description = description;
        this.exits = new HashMap<String, Integer>();
    }

    public void addExit(String direction, int location){
        exits.put(direction, location);
    }

    public Map<String, Integer> getExits() {
        return new HashMap<String, Integer>(exits);
    }

    public int getLocationId() {
        return LocationId;
    }

    public String getDescription() {
        return description;
    }
}
