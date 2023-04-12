package org.lab5.data;

import org.lab5.data.locationfirst.Location;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * Represents a route with a unique ID, name, coordinates, creation date, start and end locations, and distance.
 */
public final class Route implements Comparable<Route>, Serializable{
    private long id; // The value of this field must be greater than 0, The value of this field must be unique, The value of this field must be generated automatically
    private String name; // The field cannot be null, the string cannot be empty
    private Coordinates coordinates; // The field can't be null
    private java.time.LocalDateTime creationDate; // The value of this field must be generated automatically
    private Location from; // The field can't be null
    private Location to; // The field cannot be null
    private int distance; // The value of this field must be greater than 1

    private Route() {
        // Private constructor
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setFrom(Location from) {
        this.from = from;
    }

    public Location getFrom() {
        return from;
    }

    public void setTo(Location to) {
        this.to = to;
    }

    public Location getTo() {
        return to;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Route o) {
        return Integer.compare(this.distance, o.distance);
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", from=" + from +
                ", to=" + to +
                ", distance=" + distance +
                '}';
    }

    public static RouteBuilder newBuilder() {
        return new Route().new RouteBuilder();
    }

    public final class RouteBuilder {
        private RouteBuilder() {
            // private constructor
        }

        public RouteBuilder setId(long id) {
            Route.this.id = id;
            return this;
        }

        public RouteBuilder setName(String name) {
            Route.this.name = name;
            return this;
        }

        public RouteBuilder setCoordinates(Coordinates coordinates) {
            Route.this.coordinates = coordinates;
            return this;
        }

        public RouteBuilder setCreationDate(LocalDateTime creationDate) {
            Route.this.creationDate = creationDate;
            return this;
        }

        public RouteBuilder setFrom(Location from) {
            Route.this.from = from;
            return this;
        }

        public RouteBuilder setTo(Location to) {
            Route.this.to = to;
            return this;
        }

        public RouteBuilder setDistance(int distance) {
            Route.this.distance = distance;
            return this;
        }

        public Route build() {
            return Route.this;
        }
    }
}