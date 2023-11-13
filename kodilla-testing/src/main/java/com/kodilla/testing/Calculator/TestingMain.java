package com.kodilla.testing.Calculator;

public class TestingMain {
    public static void main(String[] args) {

        int a;
        int b;
        Calculator calculator = new Calculator();
        int resultAdd = calculator.add(10, 22);
        int resultSubstract = calculator.substract(44, 22);

        System.out.printf("Wynik dodawania: " + resultAdd);
        System.out.printf("\nWynik odejmowania: " + resultSubstract);
    }
}
