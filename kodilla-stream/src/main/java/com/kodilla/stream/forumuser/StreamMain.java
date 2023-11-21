package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        Forum forum = new Forum();

        Map<Integer, ForumUser> resultMap = forum.getUserList().stream()
                .filter(user -> user.getGender() == 'M')
                .filter(user -> user.getBirthDate().isBefore(LocalDate.now().minusYears(20)))
                .filter(user -> user.getPosts() > 0)
                .collect(Collectors.toMap(ForumUser::getUserID, user -> user));

        resultMap.forEach((userID, user) -> System.out.println(user + ": " + user));
    }
}
