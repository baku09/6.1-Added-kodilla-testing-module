package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    private final int userID;
    private final String username;
    private final char gender;
    private final LocalDate birthDate;
    private final int posts;

    public ForumUser(int userID, String username, char gender, LocalDate birthDate, int posts) {
        this.userID = userID;
        this.username = username;
        this.gender = gender;
        this.birthDate = birthDate;
        this.posts = posts;
    }

    public int getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public char getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPosts() {
        return posts;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userID=" + userID +
                ", username='" + username + '\'' +
                ", gender=" + gender +
                ", birthDate=" + birthDate +
                ", posts=" + posts +
                '}';
    }
}
