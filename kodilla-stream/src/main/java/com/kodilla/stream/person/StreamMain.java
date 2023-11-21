package com.kodilla.stream.person;

import com.kodilla.stream.person.People;

public class StreamMain {

    public static void main(String[] args) {
        People.getList().stream()
                .filter(s -> s.length() > 11)
                .forEach(System.out::println);
    }
}