package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
        when(statisticsMock.postsCount()).thenReturn(0);

        forumStatistics.calculateAdvStatistics(statisticsMock);
        forumStatistics.showStatistics();
    }

    @Test
    void testCalculateAdvStatisticsWithThousandPosts() {
        when(statisticsMock.postsCount()).thenReturn(1000);

        forumStatistics.calculateAdvStatistics(statisticsMock);
        forumStatistics.showStatistics();
    }

    @Test
    void testCalculateAdvStatisticsWithZeroComments() {
        when(statisticsMock.commentsCount()).thenReturn(0);

        forumStatistics.calculateAdvStatistics(statisticsMock);
        forumStatistics.showStatistics();
    }

    @Test
    void testCalculateAdvStatisticsWithCommentsLessThanPosts() {
        when(statisticsMock.postsCount()).thenReturn(5);
        when(statisticsMock.commentsCount()).thenReturn(3);

        forumStatistics.calculateAdvStatistics(statisticsMock);
        forumStatistics.showStatistics();
    }

    @Test
    void testCalculateAdvStatisticsWithCommentsMoreThanPosts() {
        when(statisticsMock.postsCount()).thenReturn(3);
        when(statisticsMock.commentsCount()).thenReturn(5);

        forumStatistics.calculateAdvStatistics(statisticsMock);
        forumStatistics.showStatistics();
    }

    @Test
    void testCalculateAdvStatisticsWithZeroUsers() {
        when(statisticsMock.usersNames()).thenReturn(java.util.Collections.emptyList());

        forumStatistics.calculateAdvStatistics(statisticsMock);
        forumStatistics.showStatistics();
    }

    @Test
    void testCalculateAdvStatisticsWithHundredUsers() {
        when(statisticsMock.usersNames()).thenReturn(java.util.Collections.nCopies(100, "User"));

        forumStatistics.calculateAdvStatistics(statisticsMock);
        forumStatistics.showStatistics();
    }
}
