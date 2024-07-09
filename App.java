package com.flight.service;

import com.flight.model.Airport;
import com.flight.model.Flight;

import java.util.*;

public class Graph {
    private Map<Airport, List<Flight>> adjacencyList;

    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addAirport(Airport airport) {
        adjacencyList.putIfAbsent(airport, new ArrayList<>());
    }

    public void addFlight(Airport source, Airport destination, int distance) {
        Flight flight = new Flight(source, destination, distance);
        adjacencyList.get(source).add(flight);
    }

    public List<Flight> getFlightsFrom(Airport airport) {
        return adjacencyList.get(airport);
    }

    public Set<Airport> getAirports() {
        return adjacencyList.keySet();
    }
}
