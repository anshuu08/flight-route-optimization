package com.flight.util;

import com.flight.model.Airport;
import com.flight.model.Flight;
import com.flight.service.Graph;
import java.util.*;

public class DijkstraAlgorithm {
    public Map<Airport, Integer> findShortestPaths(Graph graph, Airport source) {
        Map<Airport, Integer> distances = new HashMap<>();
        PriorityQueue<AirportDistance> pq = new PriorityQueue<>(Comparator.comparingInt(AirportDistance::getDistance));

        pq.add(new AirportDistance(source, 0));
        distances.put(source, 0);

        while (!pq.isEmpty()) {
            AirportDistance current = pq.poll();
            Airport currentAirport = current.getAirport();

            for (Flight flight : graph.getFlightsFrom(currentAirport)) {
                int newDist = distances.get(currentAirport) + flight.getDistance();
                if (newDist < distances.getOrDefault(flight.getDestination(), Integer.MAX_VALUE)) {
                    distances.put(flight.getDestination(), newDist);
                    pq.add(new AirportDistance(flight.getDestination(), newDist));
                }
            }
        }

        return distances;
    }

    private static class AirportDistance {
        private Airport airport;
        private int distance;

        public AirportDistance(Airport airport, int distance) {
            this.airport = airport;
            this.distance = distance;
        }

        public Airport getAirport() {
            return airport;
        }

        public int getDistance() {
            return distance;
        }
    }
}
