package com.flight.model;

public class Flight {
    private Airport source;
    private Airport destination;
    private int distance;

    public Flight(Airport source, Airport destination, int distance) {
        this.source = source;
        this.destination = destination;
        this.distance = distance;
    }

    public Airport getSource() {
        return source;
    }

    public void setSource(Airport source) {
        this.source = source;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
