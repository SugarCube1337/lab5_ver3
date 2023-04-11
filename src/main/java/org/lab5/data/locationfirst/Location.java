package org.lab5.data.locationfirst;

/**
 * A class representing a location with coordinates (x, y) and a name.
 */
public class Location {
    private long x;
    private Float y; //Field cannot be null
    private String name; //Field cannot be null


    public Location(long x, Float y, String name) {
        if (y == null) {
            throw new IllegalArgumentException("y coordinate cannot be null");
        }
        if (name == null) {
            throw new IllegalArgumentException("name cannot be null");
        }
        this.x = x;
        this.y = y;
        this.name = name;
    }


    public long getX() {
        return x;
    }


    public void setX(long x) {
        this.x = x;
    }

    public Float getY() {
        return y;
    }


    public void setY(Float y) {
        if (y == null) {
            throw new IllegalArgumentException("y coordinate cannot be null");
        }
        this.y = y;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name cannot be null");
        }
        this.name = name;
    }
}
