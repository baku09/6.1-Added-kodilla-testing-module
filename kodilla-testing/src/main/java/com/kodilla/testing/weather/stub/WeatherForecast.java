package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }
    public double calculateAverageTemperature() {
        return temperatures.getTemperatures().values().stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(Double.NaN);
    }

    public double calculateMedianTemperature() {
        List<Double> sortedTemperatures = new ArrayList<>(temperatures.getTemperatures().values());
        Collections.sort(sortedTemperatures);

        int size = sortedTemperatures.size();

        if (size % 2 == 0) {
            int middleIndex = size / 2;
            double middleValue1 = sortedTemperatures.get(middleIndex - 1);
            double middleValue2 = sortedTemperatures.get(middleIndex);
            return (middleValue1 + middleValue2) / 2.0;
        } else {
            int middleIndex = size / 2;
            return sortedTemperatures.get(middleIndex);
        }
    }
}