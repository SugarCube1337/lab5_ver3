package org.lab5.data;

/**
 * A class representing a pair of coordinates (x, y).
 */
public class Coordinates {
    private Double x; //The field cannot be null
    private int y;


    public Coordinates(Double x, int y) {
        if (x == null) {
            throw new IllegalArgumentException("x coordinate cannot be null");
        }
        this.x = x;
        this.y = y;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        if (x == null) {
            throw new IllegalArgumentException("x coordinate cannot be null");
        }
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
