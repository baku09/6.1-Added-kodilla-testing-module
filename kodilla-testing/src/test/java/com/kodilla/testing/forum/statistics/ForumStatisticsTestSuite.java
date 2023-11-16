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
        when(statisticsMock.postsCount()).thenReturn(5);
        when(statisticsMock.commentsCount()).thenReturn(3);
        // When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        // Then
        assertEquals(5, forumStatistics.getPostCount());
        assertEquals(3, forumStatistics.getCommentCount());;
    }

    @Test
    void testCalculateAdvStatisticsWithCommentsMoreThanPosts() {
        // Given
        when(statisticsMock.postsCount()).thenReturn(3);
        when(statisticsMock.commentsCount()).thenReturn(5);
        // When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        // Then
        assertEquals(3, forumStatistics.getPostCount());
        assertEquals(5, forumStatistics.getCommentCount());
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
