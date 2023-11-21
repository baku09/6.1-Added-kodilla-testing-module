package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {
    private final List<ForumUser> userList = new ArrayList<>();

    public Forum(){
        userList.add(new ForumUser(1,"Jakub", 'M', LocalDate.of(1999, 6, 3), 9));
        userList.add(new ForumUser(2,"Karol", 'M', LocalDate.of(1990, 11, 7), 22));
        userList.add(new ForumUser(3,"Zosia", 'F', LocalDate.of(2005, 9, 24), 1));
        userList.add(new ForumUser(4,"Antek", 'M', LocalDate.of(2010, 7, 30), 11));
        userList.add(new ForumUser(5,"Kasia", 'F', LocalDate.of(1977, 1, 23), 56));
    }
    public List<ForumUser> getUserList(){
        return new ArrayList<>(userList);
    }
}
