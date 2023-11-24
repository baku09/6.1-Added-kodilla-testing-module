package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ForumStatisticsTestSuite {
    private Statistics statisticsMock;
    private ForumStatistics forumStatistics;

    @BeforeEach
    void setUp() {
        statisticsMock = mock(Statistics.class);
        forumStatistics = new ForumStatistics();
    }

    @Test
    void testCalculateAdvStatisticsWithZeroPosts() {
        // Given
        when(statisticsMock.postsCount()).thenReturn(0);
        // When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        // Then
        assertEquals(0, forumStatistics.getPostCount());
        assertEquals(0, forumStatistics.getAveragePostsPerUser());
        assertEquals(0, forumStatistics.getAverageCommentsPerPost());
        assertEquals(0, forumStatistics.getCommentCount());
        assertEquals(0, forumStatistics.getAverageCommentsPerUser());
        assertEquals(0, forumStatistics.getUserCount());

    }

    @Test
    void testCalculateAdvStatisticsWithThousandPosts() {
        // Given
        when(statisticsMock.postsCount()).thenReturn(1000);
        // When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        // Then
        assertEquals(1000, forumStatistics.getPostCount());

    }

    @Test
    void testCalculateAdvStatisticsWithZeroComments() {
        // Given
        when(statisticsMock.commentsCount()).thenReturn(0);
        // When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        // Then
        assertEquals(0, forumStatistics.getCommentCount());

    }

    @Test
    void testCalculateAdvStatisticsWithCommentsLessThanPosts() {
        // Given
        when(statisticsMock.postsCount()).thenReturn(10);
        when(statisticsMock.commentsCount()).thenReturn(10);
        // When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        // Then
        assertEquals(10, forumStatistics.getPostCount());
        assertEquals(10, forumStatistics.getCommentCount());
        assertEquals(1.0, forumStatistics.getAverageCommentsPerPost(),0.01);

    }

    @Test
    void testCalculateAdvStatisticsWithCommentsMoreThanPosts() {
        // Given
        when(statisticsMock.postsCount()).thenReturn(5);
        when(statisticsMock.commentsCount()).thenReturn(50);
        // When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        // Then
        assertEquals(5, forumStatistics.getPostCount());
        assertEquals(50, forumStatistics.getCommentCount());
        assertEquals(10.0, forumStatistics.getAverageCommentsPerPost(),0.01);

    }

    @Test
    void testCalculateAdvStatisticsWithZeroUsers() {
        // Given
        when(statisticsMock.usersNames()).thenReturn(java.util.Collections.emptyList());
        // When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        // Then
        assertEquals(0, forumStatistics.getUserCount());

    }

    @Test
    void testCalculateAdvStatisticsWithHundredUsers() {
        // Given
        when(statisticsMock.usersNames()).thenReturn(java.util.Collections.nCopies(100, "User"));
        // When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        // Then
        assertEquals(100, forumStatistics.getUserCount());

    }
}
