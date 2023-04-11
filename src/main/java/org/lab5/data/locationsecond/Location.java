package org.lab5.data.locationsecond;

/**
 * A class representing a location with coordinates (x, y) and a name.
 */
public class Location {
    private Float x; //Field cannot be null
    private Integer y; //The field can't be null
    private String name; //The field cannot be null


    public Location(Float x, Integer y, String name) {
        if (x == null) {
            throw new IllegalArgumentException("x coordinate cannot be null");
        }
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


    public Float getX() {
        return x;
    }


    public void setX(Float x) {
        if (x == null) {
            throw new IllegalArgumentException("x coordinate cannot be null");
        }
        this.x = x;
    }


    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
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
