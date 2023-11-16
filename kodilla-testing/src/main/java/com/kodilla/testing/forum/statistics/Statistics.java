package com.kodilla.testing.forum.statistics;

import java.util.List;

public interface Statistics {
    List<String> usersNames(); // list of users names - lista nazw użytkowników
    int postsCount();          // total quantity of forum posts - całkowita liczba postów na forum
    int commentsCount();       // total quantity of forum comments - całkowita liczba komentarzy na forum
}