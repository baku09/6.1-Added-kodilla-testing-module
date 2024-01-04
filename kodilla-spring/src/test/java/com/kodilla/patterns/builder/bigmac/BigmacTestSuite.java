package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigmacTestSuite {

    @Test
    void testBigMac() {
        //Given
        Bigmac bigmac = new Bigmac.BigMacBuilder()
                .bun("Sesame")
                .burgers(4)
                .sauce("1000 wysp")
                .ingredients("cheese")
                .ingredients("bacon")
                .ingredients("onion")
                .ingredients("Jalapeno")
                .build();

        //When
        String bun = bigmac.getBun();
        int burgers = bigmac.getBurgers();
        String sauce = bigmac.getSauce();
        int ingredientsCount = bigmac.getIngredients().size();

        //Then
        assertEquals("Sesame", bun);
        assertEquals("1000 wysp", sauce);
        assertEquals(4, burgers);
        assertEquals(4, ingredientsCount);
    }
}
