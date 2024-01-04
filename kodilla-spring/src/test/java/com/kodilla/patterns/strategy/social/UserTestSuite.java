package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {
        // Given
        User steven = new Millenials("Steven Links");
        User john = new YGeneration("John Hemerald");
        User jane = new ZGeneration("Jane Smith");

        // When
        String stevenUsing = steven.sharePost();
        String johnUsing  = john.sharePost();
        String janeUsing = jane.sharePost();

        //Then
        assertEquals("Steven Links is using FacebookPublisher", stevenUsing);
        assertEquals("John Hemerald is using TwitterPublisher", johnUsing);
        assertEquals("Jane Smith is using SnapchatPublisher", janeUsing);
    }

}
