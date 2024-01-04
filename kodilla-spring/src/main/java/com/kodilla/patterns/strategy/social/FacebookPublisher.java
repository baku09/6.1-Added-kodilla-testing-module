package com.kodilla.patterns.strategy.social;

public class FacebookPublisher implements SocialPublisher{
    @Override
    public void share() {
        System.out.println("Facebook");
    }
}
