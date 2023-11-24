package com.kodilla.exception.test;

public final class Flight {
    private final String departureAiport;
    private final String arrivalAiport;

    public Flight(String departureAiport, String arrivalAiport) {
        this.departureAiport = departureAiport;
        this.arrivalAiport = arrivalAiport;
    }

    public String getDepartureAirport() {
        return departureAiport;
    }

    public String getArrivalAirport() {
        return arrivalAiport;
    }


}
