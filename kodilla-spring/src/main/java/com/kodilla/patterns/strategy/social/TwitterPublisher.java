package com.kodilla.patterns.strategy.social;

public class TwitterPublisher implements SocialPublisher{
    @Override
    public void share() {
        System.out.println("Twitter");
    }
}
