package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity() {
        // Given
        World world = new World();

        Continent europe = new Continent();
        europe.addCountry(new Country("France", new BigDecimal("67081000")));
        europe.addCountry(new Country("Germany", new BigDecimal("83166711")));

        Continent asia = new Continent();
        asia.addCountry(new Country("China", new BigDecimal("1409517397")));
        asia.addCountry(new Country("India", new BigDecimal("1366672482")));

        world.addContinent(europe);
        world.addContinent(asia);

        // When
        BigDecimal population = world.getPeopleQuantity();

        // Then
        assertEquals(new BigDecimal("2926437590"), population);
    }
}
