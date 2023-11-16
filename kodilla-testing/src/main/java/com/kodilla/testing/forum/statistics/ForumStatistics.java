package com.kodilla.testing.forum.statistics;

import java.util.List;

public class ForumStatistics {
    private int userCount; // liczba użytkowników
    private int postCount; // liczba postów
    private int commentCount; // liczba komentarzy
    private double averagePostsPerUser; // średnia postów na użytkownika
    private double averageCommentsPerUser; // średnia komentarzy na użytkownika
    private double averageCommentsPerPost; // średnia komentarzy na posty

    public void calculateAdvStatistics(Statistics statistics) {
        List<String> users = statistics.usersNames();
        userCount = users.size();
        postCount = statistics.postsCount();
        commentCount = statistics.commentsCount();

        if (userCount > 0) {
            averagePostsPerUser = (double) postCount / userCount;
            averageCommentsPerUser = (double) commentCount / userCount;
        } else {
            averagePostsPerUser = 0;
            averageCommentsPerUser = 0;
        }

        if (postCount > 0) {
            averageCommentsPerPost = (double) commentCount / postCount;
        } else {
            averageCommentsPerPost = 0;
        }
    }

    public void showStatistics() {
        System.out.println("Forum Statistics:");
        System.out.println("Number of users: " + userCount);
        System.out.println("Number of posts: " + postCount);
        System.out.println("Number of comments: " + commentCount);
        System.out.println("Average posts per user: " + averagePostsPerUser);
        System.out.println("Average comments per user: " + averageCommentsPerUser);
        System.out.println("Average comments per post: " + averageCommentsPerPost);
    }

    public int getUserCount() {
        return userCount;
    }

    public int getPostCount() {
        return postCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public double getAveragePostsPerUser() {
        return averagePostsPerUser;
    }

    public double getAverageCommentsPerUser() {
        return averageCommentsPerUser;
    }

    public double getAverageCommentsPerPost() {
        return averageCommentsPerPost;
    }
}
