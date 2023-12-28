package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;
    private Display display;

    @Test
    public void testCalculator(){
        //Given
        double a = 10;
        double b = 5;
        //When
        double addResult = calculator.add(a, b);
        double subResult = calculator.sub(a, b);
        double mulResult = calculator.mul(a, b);
        double divResult = calculator.div(a, b);
        //Then
        assertEquals(15.0, addResult, 0.01);
        assertEquals(5.0, subResult, 0.01);
        assertEquals(50.0, mulResult, 0.01);
        assertEquals(2.0, divResult, 0.01);
    }
}
