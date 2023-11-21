package com.kodilla.stream.array;

import java.util.stream.IntStream;

public interface ArrayOperations {
    static double getAverage(int[] numbers) {
        System.out.println("Elements of the array:");
        IntStream.range(0, numbers.length)
                .forEach(i -> System.out.print(numbers[i] + " "));

        double average = IntStream.of(numbers)
                .average()
                .orElse(0.0);

        System.out.println("\nAverage: " + average);
        return average;
    }
}

