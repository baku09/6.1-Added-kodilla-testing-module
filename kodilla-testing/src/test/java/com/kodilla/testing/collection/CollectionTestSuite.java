package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectionTestSuite {
    private OddNumbersExterminator exterminator;

    @BeforeEach
    void setUp(){
        exterminator = new OddNumbersExterminator();
        System.out.println("Test: " +   exterminator.getClass().getSimpleName());
    }

    @AfterEach
    void end(){
        System.out.println("Test: end");
    }


    @Test
    @DisplayName("when list is empty, " +
            "then exterminate() should return an empty list")

    void testOddNumbersExterminatorEmptyList() {
        //Given
        List<Integer> emptyList = new ArrayList<>();

        //When
        List<Integer> result = exterminator.exterminate(emptyList);

        //Then
        Assertions.assertEquals(emptyList, result);
    }

        @Test
        @DisplayName("when list contains both even and odd numbers, " +
                "then exterminate() should return a list with even numbers only")
        void testOddNumbersExterminatorNormalList() {
            // Given
            List<Integer> mixedList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
            List<Integer> expectedList = Arrays.asList(2, 4, 6, 8, 10);

            // When
            List<Integer> result = exterminator.exterminate(mixedList);

            // Then
            Assertions.assertEquals(expectedList, result);
    }
}
