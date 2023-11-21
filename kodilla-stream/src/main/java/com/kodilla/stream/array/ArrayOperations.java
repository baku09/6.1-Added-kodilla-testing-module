package com.kodilla.stream.array;

import java.util.stream.IntStream;

public interface ArrayOperations {
     static double getAverage(int[] numbers){
         System.out.println("Array elements:");
         IntStream.range(0, numbers.length)
                 .forEach(i -> {
                     System.out.println(numbers[i] + " ");
                 });
         System.out.println("Calculate average:");
         return IntStream.range(0, numbers.length)
                 .average()
                 .orElse(0);
     }
}
