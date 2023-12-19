package com.kodilla.spring.forum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ForumUserTestSuite {

    @Test
    public void testGetUsername(){
        //Given
        ForumUser forumUser = new ForumUser();
        //When
        String username = forumUser.getUsername();
        //Then
        assertEquals("John Smith", username);
    }
}
