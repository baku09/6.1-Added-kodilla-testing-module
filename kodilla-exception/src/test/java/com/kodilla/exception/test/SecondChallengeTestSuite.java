package com.kodilla.exception.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class SecondChallengeTestSuite {
    private final SecondChallenge secondChallenge = new SecondChallenge();

    @Test
    void probablyIWillThrowException(){
        //Given
        double x = 1.5;
        double y = 2.0;
        //When % Then
        assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(x, y));
    }
}
