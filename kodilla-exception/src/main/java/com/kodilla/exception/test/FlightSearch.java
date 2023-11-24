package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearch {
    private final Map<String, Boolean> airportMap;

    public FlightSearch() {
        this.airportMap = createAirportMap();
    }

    public boolean findFlight(Flight flight) throws RouteNotFoundException {
        if (!airportMap.containsKey(flight.getArrivalAirport())) {
            throw new RouteNotFoundException("not found Fly to: " + flight.getArrivalAirport());
        }
        return airportMap.get(flight.getArrivalAirport());
    }

    private Map<String, Boolean> createAirportMap() {
        Map<String, Boolean> airportMap = new HashMap<>();
        airportMap.put("Warsaw", true);
        airportMap.put("Los Angeles", true);
        airportMap.put("Barcelona", false);
        airportMap.put("Wroclaw", true);
        return airportMap;
    }

    public static void main(String[] args) {
        FlightSearch flightSearch = new FlightSearch();
        Flight validFlight1 = new Flight("Warsaw", "Los Angeles");
        Flight invalidFlight1 = new Flight("Warsaw", "HongKong");
        Flight validFlight2 = new Flight("Warsaw", "Barcelona");
        Flight invalidFlight2 = new Flight("Warsaw", "Las Vegas");

        try {
            boolean isValid = flightSearch.findFlight(validFlight1);
            System.out.println("Fly to Los Angeles: " + isValid);
        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            boolean isValid = flightSearch.findFlight(invalidFlight1);
            System.out.println("Fly to HongKong: " + isValid);
        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            boolean isValid = flightSearch.findFlight(validFlight2);
            System.out.println("Fly to Barcelona: " + isValid);
        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            boolean isValid = flightSearch.findFlight(invalidFlight2);
            System.out.println("Fly to Las Vegas: " + isValid);
        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}
