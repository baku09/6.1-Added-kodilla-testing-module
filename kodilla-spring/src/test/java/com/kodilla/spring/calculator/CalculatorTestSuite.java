package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;

    @Test
    public void testCalculator(){
        //Given
        double a = 8;
        double b = 4;
        //When
        calculator.add(a, b);
        calculator.sub(a, b);
        calculator.mul(a, b);
        calculator.div(a, b);
        //Then
        assertEquals(12.0 , a + b);
        assertEquals(4.0 , a - b);
        assertEquals(32.0 , a * b);
        assertEquals(2.0 , a / b);
    }
}
